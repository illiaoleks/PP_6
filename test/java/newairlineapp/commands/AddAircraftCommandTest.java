package newairlineapp.commands;

import newairlineapp.airline.Airline;
import newairlineapp.airline.CargoAircraft;
import newairlineapp.airline.PassengerAircraft;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class AddAircraftCommandTest {

    private Airline airline;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        airline = mock(Airline.class);
        scanner = mock(Scanner.class);
    }

    @Test
    void testAddPassengerAircraft() {
        // Simulate input sequence for passenger aircraft using nextLine()
        when(scanner.nextLine())
                .thenReturn("1") // Choice: 1 (Passenger Aircraft)
                .thenReturn("Boeing737") // Model
                .thenReturn("5000") // Range
                .thenReturn("1500") // Fuel consumption
                .thenReturn("200"); // Passenger capacity

        AddAircraftCommand command = new AddAircraftCommand(airline, scanner);
        command.execute();

        // Verify that addAircraft was called once with a PassengerAircraft
        verify(airline, times(1)).addAircraft(any(PassengerAircraft.class));

        // Verify the correct number of calls to nextLine()
        verify(scanner, times(5)).nextLine(); // Called 5 times (choice, model, range, fuel, capacity)
    }

    @Test
    void testAddCargoAircraft() {
        // Simulate input sequence for cargo aircraft using nextLine()
        when(scanner.nextLine())
                .thenReturn("2") // Choice: 2 (Cargo Aircraft)
                .thenReturn("AirbusA330") // Model
                .thenReturn("6000") // Range
                .thenReturn("1800") // Fuel consumption
                .thenReturn("50000"); // Cargo capacity

        AddAircraftCommand command = new AddAircraftCommand(airline, scanner);
        command.execute();

        // Verify that addAircraft was called once with a CargoAircraft
        verify(airline, times(1)).addAircraft(any(CargoAircraft.class));

        // Verify the correct number of calls to nextLine()
        verify(scanner, times(5)).nextLine(); // Called 5 times (choice, model, range, fuel, capacity)
    }

    @Test
    void testInvalidChoice() {
        // Simulate invalid choice
        when(scanner.nextLine())
                .thenReturn("3"); // Invalid choice

        AddAircraftCommand command = new AddAircraftCommand(airline, scanner);
        command.execute();

        // Verify that addAircraft was not called
        verify(airline, times(0)).addAircraft(any());

        // Verify the correct number of calls to nextLine()
        verify(scanner, times(1)).nextLine(); // Only the choice was read
    }
}
