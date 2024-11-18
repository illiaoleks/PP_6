package newairlineapp.airline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CargoAircraftTest {

    private CargoAircraft cargoAircraft;

    @BeforeEach
    public void setUp() {
        cargoAircraft = new CargoAircraft("Boeing 747-8F", 8000.0, 3000.0, 14000.0);
    }

    @Test
    public void testGetModel() {
        assertEquals("Boeing 747-8F", cargoAircraft.getModel(), "Модель повинна бути Boeing 747-8F");
    }

    @Test
    public void testSetModel() {
        cargoAircraft.setModel("Airbus A330F");
        assertEquals("Airbus A330F", cargoAircraft.getModel(), "Модель повинна бути Airbus A330F");
    }

    @Test
    public void testGetRange() {
        assertEquals(8000.0, cargoAircraft.getRange(), "Дальність повинна бути 8000.0");
    }

    @Test
    public void testSetRange() {
        cargoAircraft.setRange(8500.0);
        assertEquals(8500.0, cargoAircraft.getRange(), "Дальність повинна бути 8500.0");
    }

    @Test
    public void testGetFuelConsumption() {
        assertEquals(3000.0, cargoAircraft.getFuelConsumption(), "Споживання пального повинно бути 3000.0");
    }

    @Test
    public void testSetFuelConsumption() {
        cargoAircraft.setFuelConsumption(3200.0);
        assertEquals(3200.0, cargoAircraft.getFuelConsumption(), "Споживання пального повинно бути 3200.0");
    }

    @Test
    public void testGetCargoCapacity() {
        assertEquals(14000.0, cargoAircraft.getCargoCapacity(), "Вантажопідйомність повинна бути 14000.0");
    }

    @Test
    public void testSetCargoCapacity() {
        cargoAircraft.setCargoCapacity(15000.0);
        assertEquals(15000.0, cargoAircraft.getCargoCapacity(), "Вантажопідйомність повинна бути 15000.0");
    }

    @Test
    public void testToString() {
        String expected = "\tТип: CargoAircraft\n" +
                "\tМодель: Boeing 747-8F\n" +
                "\tДальність польоту: 8000.0\n" +
                "\tСпоживання пального: 3000.0\n" +
                "\tВантажопідйомність: 14000.0\n";
        assertEquals(expected, cargoAircraft.toString(), "Вихідний рядок toString неправильний");
    }
}
