## Device Power Adapter

A Java implementation of the Adapter Design Pattern for plugging different device types into a common power outlet interface.

## 📋 Overview

This project shows how to use the Adapter Pattern to make heterogeneous devices (laptop, refrigerator, smartphone charger) compatible with a single `PowerOutlet` target interface. Each device keeps its own API, while an adapter translates calls to the common `plugIn()` method.

## 🏗️ Architecture

The project follows the Adapter Design Pattern with the following components:

### Core Target Interface
- `PowerOutlet`: Defines the `plugIn()` method used by clients

### Adaptees (Existing/External APIs)
- `Laptop`: Provides `charge()`
- `Refrigerator`: Provides `startCooling()`
- `SmartphoneCharger`: Provides `chargePhone()`

### Adapters (Translate to Target)
- `LaptopAdapter`: Implements `PowerOutlet` and delegates to `Laptop.charge()`
- `RefrigeratorAdapter`: Implements `PowerOutlet` and delegates to `Refrigerator.startCooling()`
- `SmartphoneAdapter`: Implements `PowerOutlet` and delegates to `SmartphoneCharger.chargePhone()`

## 📁 Project Structure

```
device-power-adapter/
├── README.md                         # This file
└── src/
    ├── DeviceApp.java               # Main client (console app)
    ├── PowerOutlet.java             # Target interface
    ├── Laptop.java                  # Adaptee
    ├── LaptopAdapter.java           # Adapter for Laptop
    ├── Refrigerator.java            # Adaptee
    ├── RefrigeratorAdapter.java     # Adapter for Refrigerator
    ├── SmartphoneCharger.java       # Adaptee
    ├── SmartphoneAdapter.java       # Adapter for SmartphoneCharger
    └── UML Class Diagram.png        # Architecture diagram
```

## 🚀 Usage

### Running the Application

Requirements: Java 8+ (JDK)

- Windows PowerShell:
```powershell
# Compile (PowerShell doesn't expand wildcards for external programs)
$sources = Get-ChildItem -Path src -Filter *.java | ForEach-Object { $_.FullName }
javac -d out $sources

# Run
java -cp out AdapterPattern.DeviceApp
```

- macOS/Linux or Windows CMD:
```bash
# Compile (shell expands the wildcard)
javac -d out src/*.java

# Run
java -cp out AdapterPattern.DeviceApp
```

### Example Output

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

## 💡 Design Pattern Benefits

### Adapter Pattern Advantages
1. **Separation of Concerns**: Device-specific logic stays in adaptee classes; adapters isolate integration logic.
2. **Extensibility**: Add new device types by creating new adapters without changing existing client code.
3. **Uniform Interface**: Clients depend only on `PowerOutlet` regardless of the underlying device.
4. **Single Responsibility**: Each adapter handles one translation from target to adaptee API.

### Key Features
- **Interface-First Design**: Clients program to the `PowerOutlet` interface.
- **Type-Specific Delegation**: Each adapter calls the appropriate adaptee method.
- **Simple Console UI**: Interactive menu to trigger device actions.

## 🔧 Implementation Details

### Target Interface
```java
interface PowerOutlet {
    String plugIn();
}
```

### Adaptees
```java
class Laptop { String charge() { return "The laptop is in the process of charging!"; } }
class Refrigerator { String startCooling() { return "The refrigerator is cold and actively cooling!"; } }
class SmartphoneCharger { String chargePhone() { return "The smartphone is now charging!"; } }
```

### Adapters
```java
class LaptopAdapter implements PowerOutlet {
    private final Laptop laptop;
    public LaptopAdapter(Laptop laptop) { this.laptop = laptop; }
    public String plugIn() { return laptop.charge(); }
}

class RefrigeratorAdapter implements PowerOutlet {
    private final Refrigerator refrigerator;
    public RefrigeratorAdapter(Refrigerator refrigerator) { this.refrigerator = refrigerator; }
    public String plugIn() { return refrigerator.startCooling(); }
}

class SmartphoneAdapter implements PowerOutlet {
    private final SmartphoneCharger smartphoneCharger;
    public SmartphoneAdapter(SmartphoneCharger smartphoneCharger) { this.smartphoneCharger = smartphoneCharger; }
    public String plugIn() { return smartphoneCharger.chargePhone(); }
}
```

## 🎯 Use Cases

Ideal for:
- Systems integrating devices with diverse, existing APIs
- Applications needing a unified interface for different device operations
- Teaching and demonstrating structural design patterns in Java

## 🔮 Future Enhancements

Potential improvements:
- Additional devices (e.g., `Toaster`, `AirConditioner`)
- Power specifications (voltage/amperage) and validation
- Error handling and input validation in the console UI
- Unit tests and CI workflow
- GUI or REST API front-end

## 📊 UML Class Diagram
![UML Class Diagram](src/UML%20Class%20Diagram.png)

The diagram illustrates relationships between the target interface, concrete adapters, and adaptees.

## 🤝 Contributing

Contributions are welcome:
- Add new device types and adapters
- Improve the console UX and documentation
- Add tests or alternative client UIs

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

Note: This implementation demonstrates clean code principles and design patterns best practices. The Adapter pattern is particularly useful when you need to make existing classes with incompatible interfaces work together without modifying their source code.