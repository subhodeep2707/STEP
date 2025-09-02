// Assignment 7: Vehicle Fleet Management System
import java.util.*;
class Vehicle {
    String vehicleId;
    String brand;
    String model;
    int year;
    double mileage;
    String fuelType;
    String currentStatus;
    double maintenanceCost;
    double fuelConsumed;
    public Vehicle(String id,String brand,String model,int year,double mileage,String fuel){ this.vehicleId=id; this.brand=brand; this.model=model; this.year=year; this.mileage=mileage; this.fuelType=fuel; this.currentStatus="Idle"; this.maintenanceCost=0.0; this.fuelConsumed=0.0; }
    public void assignDriver(Driver d){ d.assignedVehicle=this; this.currentStatus="Assigned"; }
    public void scheduleMaintenance(double cost){ maintenanceCost+=cost; currentStatus="Maintenance"; }
    public double calculateRunningCost(double km,double fuelPrice){ double fuelUsed=km/15.0; fuelConsumed+=fuelUsed; return fuelUsed*fuelPrice; }
    public void updateMileage(double km){ mileage+=km; currentStatus="Running"; }
    public boolean checkServiceDue(){ return mileage%10000<500; }
}
class Car extends Vehicle { public Car(String id,String brand,String model,int year,double mileage,String fuel){ super(id,brand,model,year,mileage,fuel); } }
class Bus extends Vehicle { int seatingCapacity; public Bus(String id,String brand,String model,int year,double mileage,String fuel,int seat){ super(id,brand,model,year,mileage,fuel); seatingCapacity=seat; } }
class Truck extends Vehicle { double loadCapacity; public Truck(String id,String brand,String model,int year,double mileage,String fuel,double load){ super(id,brand,model,year,mileage,fuel); loadCapacity=load; } }
class Driver {
    String driverId;
    String driverName;
    String licenseType;
    Vehicle assignedVehicle;
    int totalTrips;
    public Driver(String id,String name,String type){ driverId=id; driverName=name; licenseType=type; totalTrips=0; }
}
class Fleet {
    static int totalVehicles=0;
    static double fleetValue=0.0;
    static String companyName="";
    static double totalFuelConsumption=0.0;
    Vehicle[] vehicles;
    int size;
    public Fleet(){ vehicles=new Vehicle[100]; size=0; }
    public void addVehicle(Vehicle v,double value){ vehicles[size++]=v; totalVehicles++; fleetValue+=value; }
    public static double getFleetUtilization(Fleet f){ int active=0; for(int i=0;i<f.size;i++){ if(!f.vehicles[i].currentStatus.equals("Idle")) active++; } if(f.size==0) return 0; return (active*100.0)/f.size; }
    public static double calculateTotalMaintenanceCost(Fleet f){ double s=0; for(int i=0;i<f.size;i++){ s+=f.vehicles[i].maintenanceCost; } return s; }
    public static Vehicle[] getVehiclesByType(Fleet f,String type){ ArrayList<Vehicle> list=new ArrayList<>(); for(int i=0;i<f.size;i++){ if(type.equals("Car") && f.vehicles[i] instanceof Car) list.add(f.vehicles[i]); if(type.equals("Bus") && f.vehicles[i] instanceof Bus) list.add(f.vehicles[i]); if(type.equals("Truck") && f.vehicles[i] instanceof Truck) list.add(f.vehicles[i]); } return list.toArray(new Vehicle[0]); }
    public void recordTrip(Vehicle v,double km,double fuelPrice){ double cost=v.calculateRunningCost(km,fuelPrice); v.updateMileage(km); totalFuelConsumption+=v.fuelConsumed; }
}
class Assignment7 {
    public static void main(String[] args){
        Fleet.companyName="MoveFast";
        Fleet f=new Fleet();
        Car c=new Car("V1","Maruti","Swift",2022,12000,"Petrol");
        Bus b=new Bus("V2","Tata","Star",2020,45000,"Diesel",40);
        Truck t=new Truck("V3","Ashok","Haul",2021,30000,"Diesel",8.0);
        f.addVehicle(c,600000); f.addVehicle(b,2500000); f.addVehicle(t,1800000);
        Driver d1=new Driver("D1","Sameer","LMV");
        c.assignDriver(d1);
        c.scheduleMaintenance(5000);
        f.recordTrip(c,150,100);
        System.out.println(Fleet.getFleetUtilization(f));
        System.out.println(Fleet.calculateTotalMaintenanceCost(f));
        System.out.println(Fleet.getVehiclesByType(f,"Car").length);
    }
}
