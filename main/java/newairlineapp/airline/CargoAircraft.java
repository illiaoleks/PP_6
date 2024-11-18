package newairlineapp.airline;

public class CargoAircraft extends Aircraft {
    private double cargoCapacity;

    public CargoAircraft(String model, double range, double fuelConsumption, double cargoCapacity) {
        super(model, range, fuelConsumption);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\tВантажопідйомність: " + cargoCapacity + "\n";
    }

}
