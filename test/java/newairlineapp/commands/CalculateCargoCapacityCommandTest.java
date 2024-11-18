package newairlineapp.commands;

import newairlineapp.airline.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class CalculateCargoCapacityCommandTest {

    @Mock
    private Airline airline;

    @InjectMocks
    private CalculateCargoCapacityCommand calculateCargoCapacityCommand;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        // Виклик методу execute, який повинен викликати calculateTotalCargoCapacity
        calculateCargoCapacityCommand.execute();

        // Перевірка, що метод calculateTotalCargoCapacity викликано один раз
        verify(airline, times(1)).calculateTotalCargoCapacity();
    }
}
