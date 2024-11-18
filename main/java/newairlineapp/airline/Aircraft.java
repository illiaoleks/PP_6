package newairlineapp.airline;

public class Aircraft {
    protected String model;
    protected double range;
    protected int passengerCapacity;
    protected double cargoCapacity;
    protected double fuelConsumption;

    public Aircraft(String model, double range, double fuelConsumption) {
        this.model = model;
        this.range = range;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.fuelConsumption = fuelConsumption;
    }


    public String getModel() {
        return model;
    }
    public Double getRange() {
        return range;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    @Override
    public String toString() {
        return "\tТип: " + getClass().getSimpleName() + "\n" +
                "\tМодель: " + model + "\n" +
                "\tДальність польоту: " + range + "\n" +
                "\tСпоживання пального: " + fuelConsumption + "\n";
    }


}
