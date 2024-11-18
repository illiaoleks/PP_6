package newairlineapp.commands;

import newairlineapp.airline.Airline;

import java.util.Scanner;

public class RemoveAircraftCommand implements Command {
    private Airline airline;

    public RemoveAircraftCommand(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть індекс літака для видалення: ");
        int index = scanner.nextInt() - 1;

        airline.removeAircraft(index);
        System.out.println("Літак видалено.");

    }
}
