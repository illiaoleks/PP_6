package newairlineapp.commands;

import newairlineapp.airline.Airline;

public class CalculateCapacityCommand implements Command {
    private Airline airline;

    public CalculateCapacityCommand(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        airline.calculateTotalCapacity();
    }
}
