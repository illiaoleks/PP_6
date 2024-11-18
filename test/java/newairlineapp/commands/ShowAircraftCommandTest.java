package newairlineapp.commands;

import newairlineapp.airline.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ShowAircraftCommandTest {
    private Airline airline;
    private ShowAircraftCommand showAircraftCommand;

    @BeforeEach
    public void setUp() {
        // Створюємо мок для класу Airline
        airline = Mockito.mock(Airline.class);
        // Ініціалізуємо ShowAircraftCommand з моком Airline
        showAircraftCommand = new ShowAircraftCommand(airline);
    }

    @Test
    public void testExecute() {
        // Викликаємо метод execute()
        showAircraftCommand.execute();

        // Перевіряємо, що метод showAircrafts() викликається один раз
        verify(airline, times(1)).showAircrafts();
    }
}
