public class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return "Species: " + species + ", Habitat: " + habitat +
               ", Lifespan: " + lifespan + " years, Wildlife: " + isWildlife;
    }
}

class Mammal extends Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;

    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true;
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;

    public Dog(String breed) {
        super("Dog", "Domestic", 13, false, "Brown", 63);
        this.breed = breed;
        this.isDomesticated = true;
        this.loyaltyLevel = 8;
        this.favoriteActivity = "Playing fetch";
        System.out.println("Dog constructor: Creating " + breed + " dog (basic)");
    }

    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod, String breed, boolean isDomesticated,
               int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog (detailed)");
    }

    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             other.furColor, other.gestationPeriod, other.breed,
             other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog copy constructor: Copied " + other.breed);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Loyalty level: " + loyaltyLevel + "/10");
    }

    public void demonstrateInheritance() {
        eat();
        super.eat();
        move();
        super.move();
        sleep();
        nurse();
        regulateTemperature();
        System.out.println(getAnimalInfo());
    }

    public static void main(String[] args) {
        Dog basicDog = new Dog("Labrador");
        basicDog.demonstrateInheritance();
        basicDog.bark();
        basicDog.fetch();
        basicDog.showLoyalty();

        Dog detailedDog = new Dog("Dog", "Farm", 12, false, "Golden", 60,
                                  "Golden Retriever", true, 10, "Swimming");
        detailedDog.demonstrateInheritance();

        Dog copyDog = new Dog(detailedDog);
        copyDog.demonstrateInheritance();

        System.out.println("basicDog instanceof Dog? " + (basicDog instanceof Dog));
        System.out.println("basicDog instanceof Mammal? " + (basicDog instanceof Mammal));
        System.out.println("basicDog instanceof Animal? " + (basicDog instanceof Animal));
    }
}
