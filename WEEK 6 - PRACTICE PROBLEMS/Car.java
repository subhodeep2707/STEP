import java.util.Random;

// Vehicle class (default access)
class Vehicle {
    // Protected fields (accessible to subclasses)
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // Private fields (encapsulated)
    private String registrationNumber;
    private boolean isRunning;

    // Default constructor
    public Vehicle() {
        this.brand = "DefaultBrand";
        this.model = "DefaultModel";
        this.year = 2025;
        this.engineType = "Petrol";
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // Parameterized constructor
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    // Methods
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year +
                ", Engine: " + engineType + ", RegNo: " + registrationNumber +
                ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Vehicle Specs -> Brand: " + brand + ", Model: " + model +
                ", Year: " + year + ", Engine: " + engineType);
    }

    // Getter/Setter for private fields
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }

    // Private helper to generate random registration number
    private String generateRegistrationNumber() {
        Random rand = new Random();
        int num = rand.nextInt(9000) + 1000; // 4-digit number
        return "REG" + num;
    }
}

// Car class (public, file should be named Car.java)
public class Car extends Vehicle {
    // Car-specific fields
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    // Default constructor
    public Car() {
        super(); // Calls Vehicle default constructor
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    // Parameterized constructor
    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType); // Call parent constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    // Overridden methods
    @Override
    public void start() {
        super.start(); // Call Vehicle start()
        System.out.println("Car-specific startup: Checking doors and mirrors...");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs(); // Show Vehicle specs first
        System.out.println("Car Specs -> Doors: " + numberOfDoors +
                ", Fuel: " + fuelType + ", Transmission: " + transmissionType);
    }

    // Car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    // Main method to test everything
    public static void main(String[] args) {
        System.out.println("----Testing Default Car Constructor----");
        Car defaultCar = new Car();
        defaultCar.start();
        defaultCar.displaySpecs();
        defaultCar.openTrunk();
        defaultCar.playRadio();
        System.out.println(defaultCar.getVehicleInfo());

        System.out.println("\n----Testing Parameterized Car Constructor----");
        Car paramCar = new Car("Toyota", "Corolla", 2023, "Hybrid", 4, "Hybrid", "Automatic");
        paramCar.start();
        paramCar.displaySpecs();
        paramCar.openTrunk();
        paramCar.playRadio();
        System.out.println("RegNo: " + paramCar.getRegistrationNumber());

        System.out.println("\n----Polymorphism Example----");
        Vehicle v = new Car("Honda", "Civic", 2024, "Petrol", 4, "Petrol", "Automatic");
        v.start();               // Calls Car's overridden start()
        v.displaySpecs();        // Calls Car's overridden displaySpecs()
        System.out.println(v.getVehicleInfo());
        // v.openTrunk(); // Not allowed: Vehicle reference cannot call Car-specific methods
    }
}
