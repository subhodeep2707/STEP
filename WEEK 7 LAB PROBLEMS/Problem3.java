abstract class Character {
    public abstract void attack();
}

class Warrior extends Character {
    public void attack() {
        System.out.println("⚔️ Warrior attacks with a sword! Strong defense!");
    }
}

class Mage extends Character {
    public void attack() {
        System.out.println("🪄 Mage casts a powerful spell using mana!");
    }
}

class Archer extends Character {
    public void attack() {
        System.out.println("🏹 Archer shoots a long-range arrow!");
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Character[] army = { new Warrior(), new Mage(), new Archer() };
        for (Character c : army) {
            c.attack(); // Runtime polymorphism
        }
    }
}
