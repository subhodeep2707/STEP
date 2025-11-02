// File: TransportDemo.java
class Vehicle {
    public void dispatch() {
        System.out.println("Dispatching a generic vehicle...");
    }
}

class Bus extends Vehicle {
    @Override
    public void dispatch() {
        System.out.println("Dispatching Bus: Following fixed route, checking passenger capacity.");
    }
}

class Taxi extends Vehicle {
    @Override
    public void dispatch() {
        System.out.println("Dispatching Taxi: Calculating fare by distance.");
    }
}

class Bike extends Vehicle {
    @Override
    public void dispatch() {
        System.out.println("Dispatching Bike: Eco-friendly short trip mode.");
    }
}

public class TransportDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = { new Bus(), new Taxi(), new Bike() };

        for (Vehicle v : fleet) {
            v.dispatch(); // runtime decides
        }
    }
}
