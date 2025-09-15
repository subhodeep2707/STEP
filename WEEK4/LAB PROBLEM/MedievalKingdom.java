abstract class MagicalStructure {
    protected String structureName, location;
    protected int magicPower;
    protected boolean isActive;

    public MagicalStructure() {
        this("Unknown", "Nowhere", 0, false);
    }

    public MagicalStructure(String name, String location, int magicPower, boolean isActive) {
        this.structureName = name;
        this.location = location;
        this.magicPower = magicPower;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    private int spellCapacity;

    public WizardTower(String name, String location, int power, int spellCapacity) {
        super(name, location, power, true);
        this.spellCapacity = spellCapacity;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts a spell! Capacity: " + spellCapacity);
    }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;

    public EnchantedCastle(String name, String location, int power, int defenseRating) {
        super(name, location, power, true);
        this.defenseRating = defenseRating;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " defends with rating " + defenseRating);
    }
}

class KingdomManager {
    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }
}

public class MedievalKingdom {
    public static void main(String[] args) {
        System.out.println("--- Medieval Kingdom Builder ---");
        MagicalStructure t1 = new WizardTower("Tower of Light", "North", 50, 5);
        MagicalStructure c1 = new EnchantedCastle("Royal Castle", "Center", 80, 10);
        t1.castMagicSpell();
        c1.castMagicSpell();
        MagicalStructure[] all = {t1, c1};
        System.out.println("Total Kingdom Magic Power: " + KingdomManager.calculateKingdomMagicPower(all));
    }
}