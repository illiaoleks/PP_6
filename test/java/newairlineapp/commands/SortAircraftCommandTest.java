package newairlineapp.commands;

import newairlineapp.airline.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SortAircraftCommandTest {
    private Airline airline;
    private SortAircraftCommand sortAircraftCommand;

    @BeforeEach
    public void setUp() {
        // Створюємо мок для класу Airline
        airline = Mockito.mock(Airline.class);
        // Ініціалізуємо SortAircraftCommand з моком Airline
        sortAircraftCommand = new SortAircraftCommand(airline);
    }

    @Test
    public void testExecute() {
        // Викликаємо метод execute()
        sortAircraftCommand.execute();

        // Перевіряємо, що метод sortAircraftsByRange() викликається один раз
        verify(airline, times(1)).sortAircraftsByRange();
    }
}
