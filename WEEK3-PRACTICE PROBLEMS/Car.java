import java.util.*;

public class Car {
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    Car(String b, String m, int y, String c) {
        brand = b;
        model = m;
        year = y;
        color = c;
        isRunning = false;
    }

    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " Car Engine Starts");
    }

    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " Car Engine Stops");
    }

    public void displayInfo() {
        System.out.println("Brand Name:" + brand + "\nModel Name:" + model + "\nYear:" + year + "\ncolor:" + color);
    }

    public static void main(String args[]) {
        Car ob1 = new Car("Maruti Suzuki", "Dzire", 2, "White");
        Car ob2 = new Car("Hyundai", "Verna", 1, "Black");
        Car ob3 = new Car("Kia", "Seltos", 3, "Silver");
        ob1.displayInfo();
        ob1.startEngine();
        ob1.stopEngine();
        ob2.displayInfo();
        ob2.startEngine();
        ob2.stopEngine();
        ob3.displayInfo();
        ob3.startEngine();
        ob3.stopEngine();
    }
}
