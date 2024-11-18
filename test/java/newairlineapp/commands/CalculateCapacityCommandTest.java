package newairlineapp.commands;

import newairlineapp.airline.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class CalculateCapacityCommandTest {

    @Mock
    private Airline airline;

    @InjectMocks
    private CalculateCapacityCommand calculateCapacityCommand;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        // Виклик методу execute, що має викликати calculateTotalCapacity
        calculateCapacityCommand.execute();

        // Перевірка, що метод calculateTotalCapacity викликано один раз
        verify(airline, times(1)).calculateTotalCapacity();
    }
}
