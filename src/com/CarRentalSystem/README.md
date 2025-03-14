# Vehicle Information System

## Overview
This assignment will assess your skills and knowledge in implementing interfaces to define contracts and enforce common behavior across multiple classes in Java.

## Project Context
You have been tasked with developing a **Vehicle Information System** for a car rental agency. The system must handle different types of vehicles, including **cars, motorcycles, and trucks**. To enforce a common behavior and ensure consistency among these vehicle types, you will utilize **interfaces**. Additionally, the system should include small modules to make the assignment engaging and interactive for developers.

## Requirements
### Vehicle Interface
- Design and implement an interface named `Vehicle` that includes methods for retrieving:
    - The vehicle's **make**
    - The vehicle's **model**
    - The vehicle's **year of manufacture**

### Car Class
- Develop a class named `Car` that implements the `Vehicle` interface and an additional `CarVehicle` interface.
- The `CarVehicle` interface should include methods to:
    - Set and retrieve the **number of doors**
    - Set and retrieve the **fuel type** (petrol, diesel, or electric)

### Motorcycle Class
- Construct a class named `Motorcycle` that implements the `Vehicle` interface and a `MotorVehicle` interface.
- The `MotorVehicle` interface should include methods to:
    - Set and retrieve the **number of wheels**
    - Set and retrieve the **type of motorcycle** (sport, cruiser, or off-road)

### Truck Class
- Create a class named `Truck` that implements the `Vehicle` interface and a `TruckVehicle` interface.
- The `TruckVehicle` interface should include methods to:
    - Set and retrieve the **cargo capacity** (in tons)
    - Set and retrieve the **transmission type** (manual or automatic)

### Main Program
- Integrate all the classes into a **main program** that allows the user to:
    - **Create objects** of different vehicle types.
    - **Input relevant information** for each vehicle.
    - **Display the details** of each vehicle.

## Assessment Criteria
Your submission will be assessed based on the following:
1. **Interface Design**: The `Vehicle` interface ensures a common contract for different vehicle types, enforcing consistency.
2. **Class Implementation**: Each class correctly implements the required interface(s) and provides appropriate methods for setting and retrieving vehicle details.
3. **Main Program Functionality**: The main program allows users to interactively create, input, and display vehicle details.
4. **Code Quality**: Code readability, maintainability, and adherence to best practices ensure a well-structured and scalable application.
5. **Error Handling**: The program effectively manages exceptions and invalid inputs to maintain a robust and stable user experience.
6. **Documentation**: Comprehensive documentation explains the functionality of each class, method, and interface, making it easy to understand and maintain.

## Running the Program
To run the **Vehicle Information System**, follow these steps:
1. Compile all Java files using:
   ```sh
   javac *.java
   ```
2. Run the main class:
   ```sh
   java Main
   ```
3. Follow the on-screen prompts to create and manage vehicle objects.

Ensure Java is installed on your system before executing the program.

---
This project will enhance your understanding of **interfaces, class implementation, and object-oriented design** in Java, demonstrating best practices for developing scalable and maintainable software applications.

