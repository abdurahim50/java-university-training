package com.VehicleSystem;

// CarVehicle.java
interface CarVehicle extends Vehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType);
    String getFuelType();
}