// Program: Vehicle Rental System
class Vehicle {
    private String vehicleId, brand, model;
    private double rentPerDay;
    private boolean isAvailable;

    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName;
    private static int rentalDays = 0;
    private static int vehicleCounter = 1;

    public Vehicle(String brand, String model, double rentPerDay) {
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.vehicleId = "V" + (vehicleCounter++);
        totalVehicles++;
    }

    public double rentVehicle(int days) {
        if (isAvailable) {
            isAvailable = false;
            double rent = calculateRent(days);
            rentalDays += days;
            totalRevenue += rent;
            return rent;
        } else {
            System.out.println("Vehicle already rented!");
            return 0;
        }
    }

    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Vehicle returned successfully!");
        } else {
            System.out.println("Vehicle was not rented!");
        }
    }

    public double calculateRent(int days) {
        return rentPerDay * days;
    }

    public void displayVehicleInfo() {
        System.out.println("ID: " + vehicleId + ", Brand: " + brand + ", Model: " + model + ", Rent/Day: " + rentPerDay + ", Available: " + isAvailable);
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static void displayCompanyStats() {
        System.out.println("Company: " + companyName + ", Total Vehicles: " + totalVehicles + ", Total Revenue: " + totalRevenue + ", Total Rental Days: " + rentalDays);
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle.setCompanyName("ZoomCars");

        Vehicle v1 = new Vehicle("Toyota", "Innova", 2000);
        Vehicle v2 = new Vehicle("Honda", "City", 1500);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();

        double rent = v1.rentVehicle(5);
        System.out.println("Rent charged: " + rent);

        v1.returnVehicle();
        Vehicle.displayCompanyStats();
    }
}
