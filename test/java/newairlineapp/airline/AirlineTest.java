package newairlineapp.airline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AirlineTest {

    private Airline airline;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        airline = new Airline();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAddAircraft() {
        Aircraft aircraft = new PassengerAircraft("Boeing 747", 13000.0, 5000.0, 400);
        airline.addAircraft(aircraft);
        assertEquals(1, airline.getAircraftList().length);
    }

    @Test
    public void testCalculateTotalCapacity() {
        airline.addAircraft(new PassengerAircraft("Boeing 747", 13000.0, 5000.0, 400));
        airline.addAircraft(new PassengerAircraft("Airbus A380", 15000.0, 6000.0, 500));

        airline.calculateTotalCapacity();
        assertTrue(outputStream.toString().contains("Загальна пасажиромісткість: 900"));
    }

    @Test
    public void testCalculateTotalCargoCapacity() {
        airline.addAircraft(new CargoAircraft("Antonov An-225", 12000.0, 8000.0, 250000.0));
        airline.addAircraft(new CargoAircraft("C-130 Hercules", 7000.0, 4000.0, 37000.0));

        airline.calculateTotalCargoCapacity();
        assertTrue(outputStream.toString().contains("Загальна вантажопідйомність: 287000.0"));
    }

    @Test
    public void testShowAircraftsEmpty() {
        airline.showAircrafts();
        assertTrue(outputStream.toString().contains("Список літаків порожній."));
    }

    @Test
    public void testShowAircraftsWithAircrafts() {
        airline.addAircraft(new PassengerAircraft("Boeing 747", 13000.0, 5000.0, 400));
        airline.showAircrafts();
        assertTrue(outputStream.toString().contains("Boeing 747"));
    }

    @Test
    public void testSortAircraftsByRange() {
        airline.addAircraft(new PassengerAircraft("Boeing 747", 13000.0, 5000.0, 400));
        airline.addAircraft(new CargoAircraft("C-130 Hercules", 7000.0, 4000.0, 37000.0));
        airline.sortAircraftsByRange();

        Aircraft[] sortedAircrafts = airline.getAircraftList();
        assertEquals("C-130 Hercules", sortedAircrafts[0].getModel());
        assertEquals("Boeing 747", sortedAircrafts[1].getModel());
    }

    @Test
    public void testFindAircraftByFuelConsumption() {
        airline.addAircraft(new PassengerAircraft("Boeing 747", 13000.0, 5000.0, 400));
        airline.addAircraft(new CargoAircraft("C-130 Hercules", 7000.0, 3000.0, 37000.0));

        airline.findAircraftByFuelConsumption(4000, 6000);
        assertTrue(outputStream.toString().contains("Boeing 747"));
    }

    @Test
    public void testSaveToFileAndLoadFromFile() throws Exception {
        airline.addAircraft(new PassengerAircraft("Boeing 737", 5000.0, 3000.0, 180));
        airline.addAircraft(new CargoAircraft("C-130 Hercules", 7000.0, 4000.0, 37000.0));

        String filename = "test_aircraft_data.txt";
        airline.saveToFile(filename);

        Airline newAirline = new Airline();
        newAirline.loadFromFile(filename);

        Aircraft[] loadedAircrafts = newAirline.getAircraftList();
        assertEquals(2, loadedAircrafts.length);
        assertEquals("Boeing 737", loadedAircrafts[0].getModel());

        // Clean up test file
        new java.io.File(filename).delete();
    }

    @Test
    public void testRemoveAircraftValidIndex() {
        airline.addAircraft(new PassengerAircraft("Boeing 747", 13000.0, 5000.0, 400));
        airline.addAircraft(new CargoAircraft("C-130 Hercules", 7000.0, 4000.0, 37000.0));

        airline.removeAircraft(0);
        assertEquals(1, airline.getAircraftList().length);
        assertEquals("C-130 Hercules", airline.getAircraftList()[0].getModel());
    }

    @Test
    public void testRemoveAircraftInvalidIndex() {
        airline.addAircraft(new PassengerAircraft("Boeing 747", 13000.0, 5000.0, 400));
        airline.removeAircraft(1); // No such index
        assertEquals(1, airline.getAircraftList().length); // Ensure list is unchanged
        assertTrue(outputStream.toString().contains("Невірний індекс."));
    }
}
