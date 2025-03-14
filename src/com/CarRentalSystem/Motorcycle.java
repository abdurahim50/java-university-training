package com.CarRentalSystem;

public class Motorcycle implements MotorVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfWheels;
    private String motorcycleType;

    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYear() { return year; }

    @Override
    public void setNumberOfWheels(int wheels) {
        if (wheels < 2 || wheels > 3) throw new IllegalArgumentException("Invalid wheel count");
        this.numberOfWheels = wheels;
    }

    @Override
    public int getNumberOfWheels() { return numberOfWheels; }

    @Override
    public void setMotorcycleType(String type) {
        if (!type.matches("sport|cruiser|off-road"))
            throw new IllegalArgumentException("Invalid motorcycle type");
        this.motorcycleType = type;
    }

    @Override
    public String getMotorcycleType() { return motorcycleType; }
}