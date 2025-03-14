package com.VehicleSystem;

// Truck.java
class Truck implements TruckVehicle {
    private String make, model, transmission;
    private int year;
    private double cargoCapacity;

    public Truck(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public void setCargoCapacity(double capacity) { this.cargoCapacity = capacity; }
    public double getCargoCapacity() { return cargoCapacity; }
    public void setTransmissionType(String transmission) {
        if (transmission.equals("manual") || transmission.equals("automatic")) {
            this.transmission = transmission;
        } else {
            throw new IllegalArgumentException("Invalid transmission type");
        }
    }
    public String getTransmissionType() { return transmission; }
}