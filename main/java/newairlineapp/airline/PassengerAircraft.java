package newairlineapp.airline;

public class PassengerAircraft extends Aircraft {
    private int passengerCapacity;

    public PassengerAircraft(String model, double range, double fuelConsumption, int passengerCapacity) {
        super(model, range, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\tПасажирська місткість: " + passengerCapacity + "\n";
    }
}
