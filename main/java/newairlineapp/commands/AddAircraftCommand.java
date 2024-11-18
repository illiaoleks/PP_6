package newairlineapp.commands;

import newairlineapp.airline.Airline;
import newairlineapp.airline.CargoAircraft;
import newairlineapp.airline.PassengerAircraft;

import java.util.Scanner;

public class AddAircraftCommand implements Command {
    private final Airline airline;
    private final Scanner scanner; // Make Scanner injectable

    public AddAircraftCommand(Airline airline, Scanner scanner) {
        this.airline = airline;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Додавання літака...");

        System.out.println("Оберіть тип літака: ");
        System.out.println("1. Пасажирський");
        System.out.println("2. Вантажний");
        System.out.print("Ваш вибір: ");

        int choice = Integer.parseInt(scanner.nextLine().trim());
        if (choice != 1 && choice != 2) {
            System.out.println("Невірний вибір.");
            return; // Завершуємо метод у разі неправильного вибору
        }

        System.out.print("Введіть марку літака: ");
        String model = scanner.nextLine().trim();

        System.out.print("Введіть дальність польоту: ");
        int range = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Введіть споживання палива: ");
        double fuelConsumption = Double.parseDouble(scanner.nextLine().trim());

        if (choice == 1) {
            System.out.print("Введіть пасажирську місткість: ");
            int passengerCapacity = Integer.parseInt(scanner.nextLine().trim());
            PassengerAircraft aircraft = new PassengerAircraft(model, range, fuelConsumption, passengerCapacity);
            airline.addAircraft(aircraft);
        } else {
            System.out.print("Введіть вантажопідйомність: ");
            double cargoCapacity = Double.parseDouble(scanner.nextLine().trim());
            CargoAircraft aircraft = new CargoAircraft(model, range, fuelConsumption, cargoCapacity);
            airline.addAircraft(aircraft);
        }

        System.out.println("Літак додано.");
    }
}
