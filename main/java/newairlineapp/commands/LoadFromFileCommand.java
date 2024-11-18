package newairlineapp.commands;

import newairlineapp.airline.Airline;

public class LoadFromFileCommand implements Command {
    private Airline airline;

    public LoadFromFileCommand(Airline airline) {
        this.airline = airline;
    }


    @Override
    public void execute() {
        airline.loadFromFile("airline.txt");
        System.out.println("Авіакомпанія завантажена з файлу.");
    }
}
