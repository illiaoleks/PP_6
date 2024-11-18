package newairlineapp.commands;

import newairlineapp.airline.Airline;

public class SaveToFileCommand implements Command {
    private Airline airline;
    public SaveToFileCommand(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        airline.saveToFile("airline.txt");

    }
}
