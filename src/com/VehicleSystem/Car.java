package com.VehicleSystem;

// Car.java
class Car implements CarVehicle {
    private String make, model, fuelType;
    private int year, doors;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public void setNumberOfDoors(int doors) { this.doors = doors; }
    public int getNumberOfDoors() { return doors; }
    public void setFuelType(String fuelType) {
        if (fuelType.equals("petrol") || fuelType.equals("diesel") || fuelType.equals("electric")) {
            this.fuelType = fuelType;
        } else {
            throw new IllegalArgumentException("Invalid fuel type");
        }
    }
    public String getFuelType() { return fuelType; }
}