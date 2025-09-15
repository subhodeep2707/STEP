import java.util.*;

final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String name, String[] stages, int lifespan, String habitat) {
        if (name == null || name.isEmpty() || stages == null || stages.length == 0 || lifespan <= 0)
            throw new IllegalArgumentException("Invalid species data");
        this.speciesName = name;
        this.evolutionStages = Arrays.copyOf(stages, stages.length);
        this.maxLifespan = lifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() { return speciesName; }
    public String[] getEvolutionStages() { return Arrays.copyOf(evolutionStages, evolutionStages.length); }
    public int getMaxLifespan() { return maxLifespan; }
    public String getHabitat() { return habitat; }
}

public class VirtualPet {
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;
    private String petName;
    private int age;
    private int happiness;
    private int health;
    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Egg","Baby","Teen","Adult"};
    static final int MAX_HAPPINESS = 100, MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    private String evolutionStage;

    private String generatePetId() { return UUID.randomUUID().toString(); }
    private void validateStat(int v) { if (v < 0 || v > 100) throw new IllegalArgumentException(); }
    private void modifyHappiness(int d) { happiness = Math.max(0, Math.min(100, happiness + d)); }
    private void modifyHealth(int d) { health = Math.max(0, Math.min(100, health + d)); }
    private void updateEvolutionStage() {
        int idx = Math.min(age / 3, species.getEvolutionStages().length - 1);
        evolutionStage = species.getEvolutionStages()[idx];
    }

    public VirtualPet() { this("Pet", new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 15, "Earth")); }
    public VirtualPet(String name) { this(name, new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 15, "Earth")); }
    public VirtualPet(String name, PetSpecies sp) { this(name, sp, 0, 50, 50); }
    public VirtualPet(String name, PetSpecies sp, int age, int happiness, int health) {
        validateStat(happiness);
        validateStat(health);
        this.petId = generatePetId();
        this.petName = name;
        this.species = sp;
        this.birthTimestamp = System.currentTimeMillis();
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        updateEvolutionStage();
    }

    public String getPetId() { return petId; }
    public PetSpecies getSpecies() { return species; }
    public long getBirthTimestamp() { return birthTimestamp; }
    public String getPetName() { return petName; }
    public int getAge() { return age; }
    public int getHappiness() { return happiness; }
    public int getHealth() { return health; }
    public String getEvolutionStage() { return evolutionStage; }

    public void setPetName(String name) { this.petName = name; }
    public void setAge(int age) { this.age = age; updateEvolutionStage(); }
    public void setHappiness(int h) { validateStat(h); this.happiness = h; }
    public void setHealth(int h) { validateStat(h); this.health = h; }

    public void feedPet(String foodType) { modifyHealth(calculateFoodBonus(foodType)); }
    public void playWithPet(String gameType) { modifyHappiness(calculateGameEffect(gameType)); }
    protected int calculateFoodBonus(String food) { return food.equals("meat") ? 10 : 5; }
    protected int calculateGameEffect(String game) { return game.equals("run") ? 15 : 8; }
    String getInternalState() { return petName + "-" + age + "-" + happiness + "-" + health; }

    @Override public String toString() { return petName + " [" + species.getSpeciesName() + "] Age:" + age; }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualPet)) return false;
        return petId.equals(((VirtualPet)o).petId);
    }
    @Override public int hashCode() { return Objects.hash(petId); }

    public static void main(String[] args) {
        VirtualPet v = new VirtualPet("Rex");
        v.feedPet("meat");
        v.playWithPet("run");
        System.out.println(v);
    }
}
