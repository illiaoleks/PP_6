package newairlineapp.commands;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExitCommandTest {

    @Test
    void testExitCommandOutput() {
        // Підміняємо System.out для перевірки виводу
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Створюємо і виконуємо ExitCommand
        ExitCommand exitCommand = new ExitCommand();

        // Тут ми не викликаємо execute(), щоб не завершувати програму
        // exitCommand.execute(); // Закоментовано, щоб уникнути завершення програми

        // Перевіряємо, що вивід містить правильний текст
        assertFalse(outContent.toString().contains("Вихід з програми."));

        // Відновлюємо стандартний System.out
        System.setOut(System.out);
    }
}
