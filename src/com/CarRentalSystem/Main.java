package com.CarRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class to interact with the car rental system.
public class Main {
    private static final List<Vehicle> vehicles = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Car\n2. Add Motorcycle\n3. Add Truck\n4. Display Vehicles\n5. Exit");
            choice = readInt("Enter choice: ");
            switch (choice) {
                case 1 -> createCar();
                case 2 -> createMotorcycle();
                case 3 -> createTruck();
                case 4 -> displayVehicles();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // Helper method to create a Car object.
    private static void createCar() {
        try {
            String make = readString("Make: ");
            String model = readString("Model: ");
            int year = readInt("Year: ");
            Car car = new Car(make, model, year);
            car.setNumberOfDoors(readInt("Number of doors: "));
            car.setFuelType(readString("Fuel type (petrol/diesel/electric): "));
            vehicles.add(car);
            System.out.println("Car added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Helper method to create a Motorcycle object.
    private static void createMotorcycle() {
        try {
            String make = readString("Make: ");
            String model = readString("Model: ");
            int year = readInt("Year: ");
            Motorcycle motorcycle = new Motorcycle(make, model, year);
            motorcycle.setNumberOfWheels(readInt("Number of wheels: "));
            motorcycle.setMotorcycleType(readString("Type (sport/cruiser/off-road): "));
            vehicles.add(motorcycle);
            System.out.println("Motorcycle added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Helper method to create a Truck object.
    private static void createTruck() {
        try {
            String make = readString("Make: ");
            String model = readString("Model: ");
            int year = readInt("Year: ");
            Truck truck = new Truck(make, model, year);
            truck.setCargoCapacity(readDouble("Cargo capacity (tons): "));
            truck.setTransmissionType(readString("Transmission (manual/automatic): "));
            vehicles.add(truck);
            System.out.println("Truck added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Helper method to display the list of vehicles.
    private static void displayVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the system!");
            return;
        }

        System.out.println("\n=== Vehicle List ===");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car car) {
                System.out.printf("Car: %s %s (%d) | Doors: %d | Fuel: %s%n",
                        car.getMake(), car.getModel(), car.getYear(),
                        car.getNumberOfDoors(), car.getFuelType());
            } else if (vehicle instanceof Motorcycle motorcycle) {
                System.out.printf("Motorcycle: %s %s (%d) | Wheels: %d | Type: %s%n",
                        motorcycle.getMake(), motorcycle.getModel(), motorcycle.getYear(),
                        motorcycle.getNumberOfWheels(), motorcycle.getMotorcycleType());
            } else if (vehicle instanceof Truck truck) {
                System.out.printf("Truck: %s %s (%d) | Cargo: %.1f tons | Transmission: %s%n",
                        truck.getMake(), truck.getModel(), truck.getYear(),
                        truck.getCargoCapacity(), truck.getTransmissionType());
            }
        }
    }

    // Helper method to read integer input from the user.
    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    // Helper method to read double input from the user.
    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Helper method to read string input from the user.
    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}