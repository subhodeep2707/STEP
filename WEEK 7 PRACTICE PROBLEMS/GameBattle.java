// File: GameBattle.java
public class GameBattle {

    // Basic attack
    public void attack(int damage) {
        System.out.println("Basic attack for " + damage + " points!");
    }

    // Attack with weapon
    public void attack(int damage, String weapon) {
        System.out.println("Attacking with " + weapon + " for " + damage + " points!");
    }

    // Critical attack
    public void attack(int damage, String weapon, boolean isCritical) {
        if (isCritical) {
            System.out.println("CRITICAL HIT! " + weapon + " deals " + (damage * 2) + " points!");
        } else {
            attack(damage, weapon); // reuse previous overload
        }
    }

    // Team attack
    public void attack(int damage, String[] teammates) {
        int totalDamage = damage * (teammates.length + 1); // +1 for self
        System.out.print("Team attack with ");
        for (String mate : teammates) {
            System.out.print(mate + " ");
        }
        System.out.println("for " + totalDamage + " total damage!");
    }

    public static void main(String[] args) {
        GameBattle battle = new GameBattle();
        battle.attack(50);
        battle.attack(75, "Sword");
        battle.attack(60, "Bow", true);
        battle.attack(40, new String[]{"Alice", "Bob"});
    }
}
