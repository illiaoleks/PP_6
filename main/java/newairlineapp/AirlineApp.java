package newairlineapp;

import newairlineapp.airline.Airline;
import newairlineapp.commands.*;
import newairlineapp.menu.Menu;

import java.util.Scanner;

public class AirlineApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airline airline = new Airline();

        // Ініціалізуємо меню
        Menu menu = new Menu();
        menu.addCommand("add", new AddAircraftCommand(airline, scanner));
        menu.addCommand("remove", new RemoveAircraftCommand(airline));
        menu.addCommand("show", new ShowAircraftCommand(airline));
        menu.addCommand("capacity", new CalculateCapacityCommand(airline));
        menu.addCommand("cargo", new CalculateCargoCapacityCommand(airline));
        menu.addCommand("sort", new SortAircraftCommand(airline));
        menu.addCommand("find", new FindAircraftByFuelCommand(airline, scanner));
        menu.addCommand("save", new SaveToFileCommand(airline));
        menu.addCommand("load", new LoadFromFileCommand(airline));
        menu.addCommand("exit", new ExitCommand());




        while (true) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
            System.out.println("║\t\t\t\tНабір команд Авіакомпанії\t\t\t\t\t\t\t║");
            System.out.println("╠═══════════════════════════════════════════════════════════════════╣");
            System.out.println("║  add:      ✈️ Додати літак\t\t\t\t\t\t\t\t\t\t║");
            System.out.println("║  remove:   ❌ Видалити літак\t\t\t\t\t\t\t\t\t\t║");
            System.out.println("║  show:     📜 Показати список літаків\t\t\t\t\t\t\t\t║");
            System.out.println("║  capacity: 👥 Розрахувати загальну пасажиромісткість\t\t\t\t║");
            System.out.println("║  cargo:    📦 Розрахувати загальну вантажопідйомність\t\t\t\t║");
            System.out.println("║  sort:     🔄 Відсортувати літаки за дальністю польоту\t\t\t║");
            System.out.println("║  find:     🔍 Знайти літаки за споживанням палива\t\t\t\t\t║");
            System.out.println("║  save:     💾 Зберегти дані у файл\t\t\t\t\t\t\t\t║");
            System.out.println("║  load:     📂 Завантажити дані з файлу\t\t\t\t\t\t\t║");
            System.out.println("║  exit:     🚪 Вихід\t\t\t\t\t\t\t\t\t\t\t\t║");
            System.out.println("╚═══════════════════════════════════════════════════════════════════╝");

            System.out.print("Введіть команду: ");

            String choice = scanner.nextLine();
            menu.executeCommand(choice);
        }
    }
}
