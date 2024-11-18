package newairlineapp.commands;

import newairlineapp.airline.Airline;

public class SortAircraftCommand implements Command {
    private Airline airline;

    public SortAircraftCommand(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        airline.sortAircraftsByRange();
        System.out.println("Літаки відсортовано за дальністю польоту.");
    }
}
