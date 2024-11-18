package newairlineapp.commands;

import newairlineapp.airline.Airline;

public class CalculateCargoCapacityCommand implements Command {
    private Airline airline;

    public CalculateCargoCapacityCommand(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        airline.calculateTotalCargoCapacity();
    }
}
