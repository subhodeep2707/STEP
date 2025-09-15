import java.util.Random;
import java.util.UUID;

class VirtualPet {
    private final String petId;
    private String petName, species;
    private int age, happiness, health;
    private String stage;
    private static int totalPetsCreated = 0;
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};

    // Default Constructor
    public VirtualPet() {
        this("MysteryEgg", randomSpecies());
    }

    // Constructor with Name only
    public VirtualPet(String petName) {
        this(petName, randomSpecies(), 0, 50, 50, "Baby");
    }

    // Constructor with Name + Species
    public VirtualPet(String petName, String species) {
        this(petName, species, 2, 60, 60, "Child");
    }

    // Full Constructor
    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stage = stage;
        totalPetsCreated++;
    }

    // Generate Unique Pet ID
    public static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    private static String randomSpecies() {
        String[] speciesArr = {"Dragon", "Cat", "Dog", "Bird"};
        return speciesArr[new Random().nextInt(speciesArr.length)];
    }

    // Methods
    public void feedPet() { happiness += 5; health += 5; }
    public void playWithPet() { happiness += 10; health -= 2; }
    public void healPet() { health = Math.min(100, health + 20); }

    public void simulateDay() {
        age++;
        happiness -= 3;
        health -= 2;
        evolvePet();
    }

    private void evolvePet() {
        if (health <= 0) stage = "Ghost";
        else {
            int idx = Math.min(age / 2, EVOLUTION_STAGES.length - 1);
            stage = EVOLUTION_STAGES[idx];
        }
    }

    public void showStatus() {
        System.out.printf("Pet [%s] %s (%s) Age:%d Happiness:%d Health:%d Stage:%s%n",
                petId, petName, species, age, happiness, health, stage);
    }
}

public class VirtualPetDaycare {
    public static void main(String[] args) {
        System.out.println("--- Virtual Pet Evolution Simulator ---");
        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Buddy");
        VirtualPet pet3 = new VirtualPet("Luna", "Dragon");

        for (int i = 0; i < 5; i++) {
            pet1.simulateDay();
            pet2.simulateDay();
            pet3.simulateDay();
        }

        pet1.showStatus();
        pet2.showStatus();
        pet3.showStatus();
    }
}