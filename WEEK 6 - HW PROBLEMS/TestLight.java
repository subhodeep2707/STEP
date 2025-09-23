class Light {
    Light() {
        System.out.println("Default Light constructor");
    }

    Light(String type) {
        this(); // calls default constructor
        System.out.println("Light type: " + type);
    }

    Light(String type, int watt) {
        this(type); // calls constructor with type
        System.out.println("Light watt: " + watt);
    }
}

class LED extends Light {
    LED() {
        super("LED"); // calls Light(String type)
        System.out.println("Default LED constructor");
    }

    LED(int brightness) {
        this(); // calls LED()
        System.out.println("LED brightness: " + brightness);
    }

    LED(String color, int brightness) {
        super(color, brightness); // calls Light(String type, int watt)
        System.out.println("LED color: " + color);
    }
}

public class TestLight {
    public static void main(String[] args) {
        LED led1 = new LED();
        System.out.println("----");
        LED led2 = new LED(100);
        System.out.println("----");
        LED led3 = new LED("Blue", 60);
    }
}
