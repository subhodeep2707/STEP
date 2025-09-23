class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
}

class Apple extends Fruit {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste); // call parent constructor
        this.variety = variety;
    }

    public void showDetails() {
        System.out.println("Apple variety: " + variety);
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
    }
}

public class Lab1 {
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.showDetails();
    }
}
