package newairlineapp.commands;

import newairlineapp.airline.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SaveToFileCommandTest {

    private Airline airline;

    @BeforeEach
    void setUp() {
        airline = mock(Airline.class);
    }

    @Test
    void testExecute() {
        // Створюємо команду SaveToFileCommand з підробленим об'єктом Airline
        SaveToFileCommand command = new SaveToFileCommand(airline);

        // Виконуємо команду
        command.execute();

        // Перевіряємо, що saveToFile був викликаний з параметром "airline.txt"
        verify(airline, times(1)).saveToFile("airline.txt");
    }
}
