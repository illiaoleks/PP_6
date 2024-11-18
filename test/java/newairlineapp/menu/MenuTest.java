package newairlineapp.menu;

import newairlineapp.commands.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MenuTest {
    private Menu menu;
    private Command mockCommand;

    @BeforeEach
    public void setUp() {
        // Ініціалізуємо об'єкт Menu
        menu = new Menu();
        // Створюємо мок об'єкта Command
        mockCommand = Mockito.mock(Command.class);
    }

    @Test
    public void testAddAndExecuteCommand() {
        // Додаємо команду з ключем "test"
        menu.addCommand("test", mockCommand);

        // Виконуємо команду з ключем "test"
        menu.executeCommand("test");

        // Перевіряємо, що метод execute() було викликано один раз
        verify(mockCommand, times(1)).execute();
    }

    @Test
    public void testExecuteNonExistingCommand() {
        // Виконуємо команду з неіснуючим ключем
        menu.executeCommand("non_existing");

        // Переконуємося, що метод execute() у mockCommand не був викликаний
        verify(mockCommand, never()).execute();
    }
}
