package newairlineapp.commands;

import newairlineapp.airline.Airline;

public class ShowAircraftCommand implements Command {
    private Airline airline;

    public ShowAircraftCommand(Airline airline) {
        this.airline = airline;

    }

    @Override
    public void execute() { airline.showAircrafts();
    }
}
