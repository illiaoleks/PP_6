package newairlineapp.menu;

import newairlineapp.commands.Command;

import java.util.HashMap;
import java.util.Map;


public class Menu {
    // Клас Меню, що зберігає команди та дозволяє їх виконувати
    private Map<String, Command> commands = new HashMap<>();

    // Метод для додавання команди до меню
    public void addCommand(String key, Command command) {
        commands.put(key, command);
    }

    public void executeCommand(String key) {
        Command command = commands.get(key);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Команда не знайдена.");
        }
    }
}
