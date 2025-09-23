class Phone {
    protected String brand;
    protected String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone constructor called: " + brand + " " + model);
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model); // Call parent constructor
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone constructor called: " + operatingSystem);
    }
}

public class Lab2 {
    public static void main(String[] args) {
        Phone p1 = new Phone("Nokia", "1100");
        SmartPhone s1 = new SmartPhone("Apple", "iPhone 15", "iOS");
        SmartPhone s2 = new SmartPhone("Samsung", "S24", "Android");
    }
}
