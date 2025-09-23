abstract class Food {
    // Template method
    public final void prepare() {
        wash();
        cook();
        serve();
    }

    abstract void wash();
    abstract void cook();
    abstract void serve();
}

class Pizza extends Food {
    void wash() { System.out.println("Washing ingredients for pizza"); }
    void cook() { System.out.println("Baking pizza"); }
    void serve() { System.out.println("Serving pizza"); }
}

class Soup extends Food {
    void wash() { System.out.println("Washing vegetables for soup"); }
    void cook() { System.out.println("Boiling soup"); }
    void serve() { System.out.println("Serving soup"); }
}

public class TestFood {
    public static void main(String[] args) {
        Food pizza = new Pizza();
        pizza.prepare();
        System.out.println("----");
        Food soup = new Soup();
        soup.prepare();
    }
}
