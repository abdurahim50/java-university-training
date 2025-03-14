package com.CarRentalSystem;

public interface TruckVehicle extends Vehicle {
    void setCargoCapacity(double tons);
    double getCargoCapacity();
    void setTransmissionType(String transmission);
    String getTransmissionType();
}