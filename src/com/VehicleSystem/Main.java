package com.VehicleSystem;

// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select vehicle type: 1) Car 2) Motorcycle 3) Truck");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Make:");
        String make = scanner.nextLine();
        System.out.println("Enter Model:");
        String model = scanner.nextLine();
        System.out.println("Enter Year:");
        int year = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            Car car = new Car(make, model, year);
            System.out.println("Enter Number of Doors:");
            car.setNumberOfDoors(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter Fuel Type (petrol/diesel/electric):");
            car.setFuelType(scanner.nextLine());
            System.out.printf("Car Created: %s %s (%d), %d doors, Fuel: %s\n", car.getMake(), car.getModel(), car.getYear(), car.getNumberOfDoors(), car.getFuelType());
        } else if (choice == 2) {
            Motorcycle bike = new Motorcycle(make, model, year);
            System.out.println("Enter Number of Wheels:");
            bike.setNumberOfWheels(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter Type (sport/cruiser/off-road):");
            bike.setMotorcycleType(scanner.nextLine());
            System.out.printf("Motorcycle Created: %s %s (%d), %d wheels, Type: %s\n", bike.getMake(), bike.getModel(), bike.getYear(), bike.getNumberOfWheels(), bike.getMotorcycleType());
        } else if (choice == 3) {
            Truck truck = new Truck(make, model, year);
            System.out.println("Enter Cargo Capacity (in tons):");
            truck.setCargoCapacity(scanner.nextDouble());
            scanner.nextLine();
            System.out.println("Enter Transmission Type (manual/automatic):");
            truck.setTransmissionType(scanner.nextLine());
            System.out.printf("Truck Created: %s %s (%d), Cargo: %.2f tons, Transmission: %s\n", truck.getMake(), truck.getModel(), truck.getYear(), truck.getCargoCapacity(), truck.getTransmissionType());
        } else {
            System.out.println("Invalid choice!");
        }
        scanner.close();
    }
}
