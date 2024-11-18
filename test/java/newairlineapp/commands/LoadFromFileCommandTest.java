package newairlineapp.commands;

import newairlineapp.airline.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class LoadFromFileCommandTest {

    @Mock
    private Airline airline;

    @InjectMocks
    private LoadFromFileCommand loadFromFileCommand;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        // Виклик методу execute
        loadFromFileCommand.execute();

        // Перевірка, що метод loadFromFile викликано з параметром "airline.txt"
        verify(airline, times(1)).loadFromFile("airline.txt");
    }
}
