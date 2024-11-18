package newairlineapp.airline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerAircraftTest {

    private PassengerAircraft passengerAircraft;

    @BeforeEach
    public void setUp() {
        passengerAircraft = new PassengerAircraft("Airbus A320", 6000.0, 2500.0, 180);
    }

    @Test
    public void testGetModel() {
        assertEquals("Airbus A320", passengerAircraft.getModel(), "Модель повинна бути Airbus A320");
    }

    @Test
    public void testSetModel() {
        passengerAircraft.setModel("Boeing 737");
        assertEquals("Boeing 737", passengerAircraft.getModel(), "Модель повинна бути Boeing 737");
    }

    @Test
    public void testGetRange() {
        assertEquals(6000.0, passengerAircraft.getRange(), "Дальність повинна бути 6000.0");
    }

    @Test
    public void testSetRange() {
        passengerAircraft.setRange(6500.0);
        assertEquals(6500.0, passengerAircraft.getRange(), "Дальність повинна бути 6500.0");
    }

    @Test
    public void testGetFuelConsumption() {
        assertEquals(2500.0, passengerAircraft.getFuelConsumption(), "Споживання пального повинно бути 2500.0");
    }

    @Test
    public void testSetFuelConsumption() {
        passengerAircraft.setFuelConsumption(2600.0);
        assertEquals(2600.0, passengerAircraft.getFuelConsumption(), "Споживання пального повинно бути 2600.0");
    }

    @Test
    public void testGetPassengerCapacity() {
        assertEquals(180, passengerAircraft.getPassengerCapacity(), "Пасажирська місткість повинна бути 180");
    }

    @Test
    public void testSetPassengerCapacity() {
        passengerAircraft.setPassengerCapacity(200);
        assertEquals(200, passengerAircraft.getPassengerCapacity(), "Пасажирська місткість повинна бути 200");
    }

    @Test
    public void testToString() {
        String expected = "\tТип: PassengerAircraft\n" +
                "\tМодель: Airbus A320\n" +
                "\tДальність польоту: 6000.0\n" +
                "\tСпоживання пального: 2500.0\n" +
                "\tПасажирська місткість: 180\n";
        assertEquals(expected, passengerAircraft.toString(), "Вихідний рядок toString неправильний");
    }
}
