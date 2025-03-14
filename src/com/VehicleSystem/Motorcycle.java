package com.VehicleSystem;

// Motorcycle.java
class Motorcycle implements MotorVehicle {
    private String make, model, type;
    private int year, wheels;

    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public void setNumberOfWheels(int wheels) { this.wheels = wheels; }
    public int getNumberOfWheels() { return wheels; }
    public void setMotorcycleType(String type) {
        if (type.equals("sport") || type.equals("cruiser") || type.equals("off-road")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid motorcycle type");
        }
    }
    public String getMotorcycleType() { return type; }
}
