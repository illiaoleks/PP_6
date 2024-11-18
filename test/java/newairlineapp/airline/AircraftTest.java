package newairlineapp.airline;

import newairlineapp.airline.Aircraft;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AircraftTest {

    private Aircraft aircraft;

    @BeforeEach
    public void setUp() {
        aircraft = new Aircraft("Boeing 747", 13000.0, 5000.0);
        aircraft.setPassengerCapacity(400);
        aircraft.setCargoCapacity(15000.0);
    }

    @Test
    public void testGetModel() {
        assertEquals("Boeing 747", aircraft.getModel(), "Модель повинна бути Boeing 747");
    }

    @Test
    public void testSetModel() {
        aircraft.setModel("Airbus A320");
        assertEquals("Airbus A320", aircraft.getModel(), "Модель повинна бути Airbus A320");
    }

    @Test
    public void testGetRange() {
        assertEquals(13000.0, aircraft.getRange(), "Дальність повинна бути 13000.0");
    }

    @Test
    public void testSetRange() {
        aircraft.setRange(15000.0);
        assertEquals(15000.0, aircraft.getRange(), "Дальність повинна бути 15000.0");
    }

    @Test
    public void testGetPassengerCapacity() {
        assertEquals(400, aircraft.getPassengerCapacity(), "Пасажиромісткість повинна бути 400");
    }

    @Test
    public void testSetPassengerCapacity() {
        aircraft.setPassengerCapacity(450);
        assertEquals(450, aircraft.getPassengerCapacity(), "Пасажиромісткість повинна бути 450");
    }

    @Test
    public void testGetCargoCapacity() {
        assertEquals(15000.0, aircraft.getCargoCapacity(), "Вантажомісткість повинна бути 15000.0");
    }

    @Test
    public void testSetCargoCapacity() {
        aircraft.setCargoCapacity(16000.0);
        assertEquals(16000.0, aircraft.getCargoCapacity(), "Вантажомісткість повинна бути 16000.0");
    }

    @Test
    public void testGetFuelConsumption() {
        assertEquals(5000.0, aircraft.getFuelConsumption(), "Споживання пального повинно бути 5000.0");
    }

    @Test
    public void testSetFuelConsumption() {
        aircraft.setFuelConsumption(5500.0);
        assertEquals(5500.0, aircraft.getFuelConsumption(), "Споживання пального повинно бути 5500.0");
    }

    @Test
    public void testToString() {
        String expected = "\tТип: Aircraft\n" +
                "\tМодель: Boeing 747\n" +
                "\tДальність польоту: 13000.0\n" +
                "\tСпоживання пального: 5000.0\n";
        assertEquals(expected, aircraft.toString(), "Вихідний рядок toString неправильний");
    }
}
