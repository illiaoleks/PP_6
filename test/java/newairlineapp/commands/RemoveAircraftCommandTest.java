package newairlineapp.commands;

import newairlineapp.airline.Aircraft;
import newairlineapp.airline.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveAircraftCommandTest {

    private Airline airline;
    private RemoveAircraftCommand removeAircraftCommand;

    @BeforeEach
    public void setUp() {
        airline = new Airline();
        removeAircraftCommand = new RemoveAircraftCommand(airline);
    }

    @Test
    public void testExecute() {
        // Додаємо кілька літаків до списку
        airline.addAircraft(new Aircraft("Boeing 737", 5000.0, 3000.0));
        airline.addAircraft(new Aircraft("Airbus A320", 5500.0, 3200.0));

        // Симулюємо введення "2" (тобто індексу 1 для видалення другого літака)
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));

        // Виконуємо команду
        removeAircraftCommand.execute();

        // Перевіряємо, що залишився лише один літак
        List<Aircraft> aircraftList = List.of(airline.getAircraftList());
        assertEquals(1, aircraftList.size());
        assertEquals("Boeing 737", aircraftList.get(0).getModel());
    }
}
