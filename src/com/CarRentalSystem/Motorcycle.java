package com.CarRentalSystem;

// Represents a motorcycle implementing the MotorVehicle interface.
public class Motorcycle implements MotorVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfWheels;
    private String motorcycleType;

    //Constructor to initialize basic motorcycle properties.
    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Implement Vehicle interface methods
    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYear() { return year; }

    // Implement MotorVehicle interface methods
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