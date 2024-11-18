package newairlineapp.airline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airline {
    private List<Aircraft> aircrafts = new ArrayList<>();


    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public void calculateTotalCapacity() {
        int totalCapacity = 0;
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.getPassengerCapacity() != 0) {
                totalCapacity += aircraft.getPassengerCapacity();
            }
        }
        System.out.println("Загальна пасажиромісткість: " + totalCapacity);
    }

    public void calculateTotalCargoCapacity() {
        double totalCargoCapacity = 0;
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.getCargoCapacity() != 0) {
                totalCargoCapacity += aircraft.getCargoCapacity();
            }
        }
        System.out.println("Загальна вантажопідйомність: " + totalCargoCapacity);
    }

    public void showAircrafts() {
        if(aircrafts.isEmpty()) {
            System.out.println("Список літаків порожній.");
            return;
        }
        System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("║\t\t\t\tСписок літаків\t\t\t\t\t\t\t\t\t\t║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════╣");
        for (Aircraft aircraft : aircrafts) {
            System.out.println(aircraft.toString());
            System.out.println("╠═══════════════════════════════════════════════════════════════════╣");
        }
        System.out.println("╚═══════════════════════════════════════════════════════════════════╝");
    }

    public void sortAircraftsByRange() {
        aircrafts.sort((a1, a2) -> (int) (a1.getRange() - a2.getRange()));
    }


    public void findAircraftByFuelConsumption(int min, int max) {
        boolean found = false;
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.getFuelConsumption() >= min && aircraft.getFuelConsumption() <= max) {
                System.out.println("Літак знайдено: ");
                System.out.println("Тип: " + aircraft.getClass().getSimpleName());
                System.out.println("Модель: " + aircraft.getModel());
                System.out.println("Дальність польоту: " + aircraft.getRange());
                System.out.println("Споживання пального: " + aircraft.getFuelConsumption());
                if (aircraft.getPassengerCapacity() != 0)
                    System.out.println("Пасажирська місткість: " + aircraft.getPassengerCapacity());
                if (aircraft.getCargoCapacity() != 0)
                    System.out.println("Вантажопідйомність: " + aircraft.getCargoCapacity());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Літаків з таким споживанням пального не знайдено.");
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Aircraft aircraft : aircrafts) {
                writer.write(aircraft.getClass().getSimpleName() + "," + aircraft.getModel() + "," + aircraft.getRange() + "," + aircraft.getFuelConsumption());
                if (aircraft.getPassengerCapacity() != 0) {
                    writer.write("," + aircraft.getPassengerCapacity());
                }
                if (aircraft.getCargoCapacity() != 0) {
                    writer.write("," + aircraft.getCargoCapacity());
                }
                writer.newLine();
            }
            System.out.println("Дані про літаки успішно збережено у файл: " + filename);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні даних про літаки: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] aircraftData = scanner.nextLine().split(",");
                String aircraftType = aircraftData[0];
                String model = aircraftData[1];
                double range = Double.parseDouble(aircraftData[2]);
                double fuelConsumption = Double.parseDouble(aircraftData[3]);

                switch (aircraftType) {
                    case "CargoAircraft":
                        double cargoCapacity = Double.parseDouble(aircraftData[4]);
                        aircrafts.add(new CargoAircraft(model, range, fuelConsumption, cargoCapacity));
                        break;
                    case "PassengerAircraft":
                        int passengerCapacity = Integer.parseInt(aircraftData[4]);
                        aircrafts.add(new PassengerAircraft(model, range, fuelConsumption, passengerCapacity));
                        break;
                    default:
                        System.out.println("Невідомий тип літака: " + aircraftType);
                        break;
                }
            }
            System.out.println("Дані про літаки успішно завантажено з файлу: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Помилка формату даних у файлі: " + e.getMessage());
        }
    }

    public Aircraft[] getAircraftList() {
        return aircrafts.toArray(new Aircraft[0]);
    }

    public void removeAircraft(int index) {
        if (index >= 0 && index < aircrafts.size()) {
            aircrafts.remove(index);
        } else {
            System.out.println("Невірний індекс.");
        }
    }
}
