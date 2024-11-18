package newairlineapp.commands;

import newairlineapp.airline.Airline;

import java.util.Scanner;

public class FindAircraftByFuelCommand implements Command {
    private final Airline airline;
    private final Scanner scanner;

    public FindAircraftByFuelCommand(Airline airline, Scanner scanner) {
        this.airline = airline;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Пошук літака за параметрами споживання пального...");

        try {
            System.out.print("Введіть діапазон споживання пального від: ");
            int from = Integer.parseInt(scanner.nextLine().trim()); // Використовуємо nextLine() і парсимо в int

            System.out.print("Введіть діапазон споживання пального до: ");
            int to = Integer.parseInt(scanner.nextLine().trim()); // Використовуємо nextLine() і парсимо в int

            // Виклик методу пошуку
            airline.findAircraftByFuelConsumption(from, to);
            System.out.println("Літаки з відповідними параметрами знайдено.");
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введіть числові значення для діапазону.");
        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}
