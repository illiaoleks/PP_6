package newairlineapp.commands;

import newairlineapp.airline.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

class FindAircraftByFuelCommandTest {

    private Airline airline;

    @BeforeEach
    void setUp() {
        airline = mock(Airline.class); // Мокаємо об'єкт Airline
    }

    @Test
    void testExecuteWithValidInput() {
        // Створюємо підроблений вхідний потік для введення даних
        String simulatedInput = "100\n500\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Створюємо команду з підробленими даними
        FindAircraftByFuelCommand command = new FindAircraftByFuelCommand(airline, scanner);
        command.execute();

        // Перевіряємо, що findAircraftByFuelConsumption був викликаний з правильними параметрами
        verify(airline, times(1)).findAircraftByFuelConsumption(100, 500);
    }

    @Test
    void testExecuteWithInvalidInput() {
        // Симулюємо введення некоректних даних
        String simulatedInput = "abc\n500\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Створюємо команду з підробленими даними
        FindAircraftByFuelCommand command = new FindAircraftByFuelCommand(airline, scanner);
        command.execute();

        // Переконуємося, що findAircraftByFuelConsumption не викликався через некоректні дані
        verify(airline, times(0)).findAircraftByFuelConsumption(anyInt(), anyInt());
    }

    @Test
    void testExecuteWithIncompleteInput() {
        // Симулюємо введення тільки одного значення
        String simulatedInput = "100\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Створюємо команду з підробленими даними
        FindAircraftByFuelCommand command = new FindAircraftByFuelCommand(airline, scanner);
        command.execute();

        // Переконуємося, що findAircraftByFuelConsumption не викликався через неповні дані
        verify(airline, times(0)).findAircraftByFuelConsumption(anyInt(), anyInt());
    }
}
