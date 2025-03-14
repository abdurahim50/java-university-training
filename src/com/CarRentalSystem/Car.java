package com.CarRentalSystem;

public class Car implements CarVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfDoors;
    private String fuelType;

    public Car(String make, String model, int year) {
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
    public void setNumberOfDoors(int doors) {
        if (doors < 1 || doors > 5) throw new IllegalArgumentException("Invalid door count");
        this.numberOfDoors = doors;
    }

    @Override
    public int getNumberOfDoors() { return numberOfDoors; }

    @Override
    public void setFuelType(String fuelType) {
        if (!fuelType.matches("petrol|diesel|electric"))
            throw new IllegalArgumentException("Invalid fuel type");
        this.fuelType = fuelType;
    }

    @Override
    public String getFuelType() { return fuelType; }
}