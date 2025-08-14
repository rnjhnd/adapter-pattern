# Plugging Devices into Power Outlets

A Java implementation of the **Adapter Design Pattern** for connecting different electronic devices to a standardized power outlet interface. This project demonstrates how to use adapter objects to make incompatible device interfaces work together seamlessly.

## 📋 Overview

The Device Power Adapter allows you to connect various electronic devices (laptop, refrigerator, smartphone charger) to a common power outlet interface. Instead of modifying existing device classes, the system uses adapter classes to translate between the device-specific APIs and the standardized `PowerOutlet` interface, making device integration more flexible and maintainable.

## 🏗️ Architecture

This project implements the **Adapter Design Pattern** with the following components:

- **PowerOutlet Interface**: Defines the standardized `plugIn()` method for all devices
- **Device Classes**: Laptop, Refrigerator, and SmartphoneCharger with their specific APIs
- **Adapter Classes**: LaptopAdapter, RefrigeratorAdapter, and SmartphoneAdapter that implement PowerOutlet
- **Main Application**: Interactive console application demonstrating the adapter pattern

### Design Pattern Benefits

- **Compatibility**: Enables devices with incompatible interfaces to work together
- **Flexibility**: Easy to add new device types by creating new adapters
- **Maintainability**: Existing device code remains unchanged
- **Reusability**: Adapters can be reused across different client applications

## 📊 UML Class Diagram

<img width="2060" height="1200" alt="UML Class Diagram" src="https://github.com/user-attachments/assets/3c0bac52-8549-4bb4-aa8e-5f20d74ca323" />

The following diagram illustrates:
- The architecture of the Device Power Adapter system
- Relationships between the core components:
  - The `PowerOutlet` interface
  - Concrete device classes: `Laptop`, `Refrigerator`, `SmartphoneCharger`
  - Adapter classes: `LaptopAdapter`, `RefrigeratorAdapter`, `SmartphoneAdapter`
  - The main application class
- How the Adapter design pattern is applied in this project

## 🚀 Features

- **Multiple Device Types**: Support for laptop, refrigerator, and smartphone charger
- **Standardized Interface**: All devices work through the common `PowerOutlet` interface
- **Interactive Console**: User-friendly menu system for device interaction
- **Extensible Design**: Easy to add new device types and adapters
- **Clean Architecture**: Well-structured, maintainable code

## 📁 Project Structure

```
device-power-adapter/
├── src/
│   ├── DeviceApp.java                  # Main application demo
│   ├── PowerOutlet.java                # Target interface
│   ├── Laptop.java                     # Laptop device implementation
│   ├── LaptopAdapter.java              # Adapter for Laptop
│   ├── Refrigerator.java               # Refrigerator device implementation
│   ├── RefrigeratorAdapter.java        # Adapter for Refrigerator
│   ├── SmartphoneCharger.java          # Smartphone charger implementation
│   └── SmartphoneAdapter.java          # Adapter for SmartphoneCharger
└── README.md                           # Project documentation
```

## 🛠️ Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Getting Started

1. **Clone or download** the project files
2. **Navigate** to the project directory
3. **Compile** the Java files:
   ```bash
   javac -d out src/*.java
   ```
4. **Run** the application:
   ```bash
   java -cp out AdapterPattern.DeviceApp
   ```

## 📖 Usage

### Basic Usage

The main application (`DeviceApp.java`) demonstrates how to use the adapter pattern:

```java
// Create device instances
Laptop laptop = new Laptop();
Refrigerator refrigerator = new Refrigerator();
SmartphoneCharger smartphoneCharger = new SmartphoneCharger();

// Create adapters for each device
PowerOutlet laptopAdapter = new LaptopAdapter(laptop);
PowerOutlet refrigeratorAdapter = new RefrigeratorAdapter(refrigerator);
PowerOutlet smartphoneAdapter = new SmartphoneAdapter(smartphoneCharger);

// Use devices through the common interface
String result1 = laptopAdapter.plugIn();      // "The laptop is in the process of charging!"
String result2 = refrigeratorAdapter.plugIn(); // "The refrigerator is cold and actively cooling!"
String result3 = smartphoneAdapter.plugIn();   // "The smartphone is now charging!"
```

### Expected Output

When you run the application, you'll see:

```
WELCOME TO DEVICE MANAGEMENT APP!

Please select a device: 
1. Laptop 
2. Refrigerator 
3. Smartphone Charger 
4. Exit 

Enter your choice: 1

The laptop is in the process of charging!

Enter your choice: 2

The refrigerator is cold and actively cooling!

Enter your choice: 3

The smartphone is now charging!

Enter your choice: 4

Exiting the program...
```

## 🔧 Extending the Project

### Adding New Device Types

To add a new device type (e.g., `Toaster`):

1. **Create** a new device class with its specific API
2. **Create** an adapter class implementing `PowerOutlet`
3. **Add** the new device to the main application

Example:
```java
public class Toaster {
    public String toast() {
        return "The toaster is heating up!";
    }
}

public class ToasterAdapter implements PowerOutlet {
    private final Toaster toaster;
    
    public ToasterAdapter(Toaster toaster) {
        this.toaster = toaster;
    }
    
    @Override
    public String plugIn() {
        return toaster.toast();
    }
}
```

## 🎯 Design Patterns Used

### Adapter Pattern
- **Purpose**: Convert the interface of a class into another interface clients expect
- **Benefits**: Enables incompatible interfaces to work together without modifying existing code
- **Implementation**: Each adapter implements the `PowerOutlet` interface and delegates to the specific device

### Interface Segregation
- **Purpose**: Keep interfaces focused and cohesive
- **Benefits**: Clients only depend on the methods they actually use
- **Implementation**: `PowerOutlet` interface defines only the essential `plugIn()` method

## 🤝 Contributing

Feel free to contribute to this project by:
- Adding new device types and adapters
- Improving the console interface
- Enhancing the adapter pattern implementation
- Adding unit tests
- Creating alternative user interfaces (GUI, web-based)

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Note**: This implementation demonstrates clean code principles and design patterns best practices. The Adapter pattern is particularly useful when you need to integrate existing classes with incompatible interfaces, when you want to reuse existing functionality without modifying source code, or when you need to provide a unified interface for multiple subsystems.
