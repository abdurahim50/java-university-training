package com.CarRentalSystem;

// Represents a truck implementing the TruckVehicle interface.
public class Truck implements TruckVehicle {
    private String make;
    private String model;
    private int year;
    private double cargoCapacity;
    private String transmissionType;

    //Constructor to initialize basic truck properties.
    public Truck(String make, String model, int year) {
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

    // Implement TruckVehicle interface methods
    @Override
    public void setCargoCapacity(double tons) {
        if (tons <= 0) throw new IllegalArgumentException("Invalid cargo capacity");
        this.cargoCapacity = tons;
    }

    @Override
    public double getCargoCapacity() { return cargoCapacity; }

    @Override
    public void setTransmissionType(String transmission) {
        if (!transmission.equalsIgnoreCase("manual") && !transmission.equalsIgnoreCase("automatic"))
            throw new IllegalArgumentException("Invalid transmission type");
        this.transmissionType = transmission;
    }

    @Override
    public String getTransmissionType() { return transmissionType; }
}