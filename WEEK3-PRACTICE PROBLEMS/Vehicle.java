
public class Vehicle {
    
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    
    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        if (amount > 0) {
            fuelLevel += amount;
            System.out.println(make + " " + model + " refueled. Current fuel: " + fuelLevel);
        } else {
            System.out.println("Invalid fuel amount.");
        }
    }

    public void displayVehicleInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Level: " + fuelLevel);
    }

    
    public static void main(String[] args) {
        
        Vehicle car = new Car("Toyota", "Camry", 2022, 50, 4);
        Vehicle truck = new Truck("Ford", "F-150", 2020, 70, 1000);
        Vehicle motorcycle = new Motorcycle("Yamaha", "R15", 2023, 20, true);

        
        Vehicle[] vehicles = {car, truck, motorcycle};

        for (Vehicle v : vehicles) {
            v.startVehicle();
            v.refuel(10);
            v.displayVehicleInfo();
            v.stopVehicle();
            System.out.println("--------------------");
        }

    }
}


class Car extends Vehicle {
    private int doors;

    public Car(String make, String model, int year, double fuelLevel, int doors) {
        super(make, model, year, fuelLevel);
        this.doors = doors;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Doors: " + doors);
    }
}


class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String make, String model, int year, double fuelLevel, double payloadCapacity) {
        super(make, model, year, fuelLevel);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Payload Capacity: " + payloadCapacity + " kg");
    }
}


class Motorcycle extends Vehicle {
    private boolean hasCarrier;

    public Motorcycle(String make, String model, int year, double fuelLevel, boolean hasCarrier) {
        super(make, model, year, fuelLevel);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Has Carrier: " + hasCarrier);
    }
}
