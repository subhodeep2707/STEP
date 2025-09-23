class Game {
    String name;

    Game(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Game: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            return this.name.equals(((Game) obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

class CardGame extends Game {
    int players;

    CardGame(String name, int players) {
        super(name);
        this.players = players;
    }

    @Override
    public String toString() {
        return super.toString() + ", Players: " + players;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CardGame) {
            CardGame cg = (CardGame) obj;
            return super.equals(cg) && this.players == cg.players;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + players;
    }
}

public class TestGame {
    public static void main(String[] args) {
        Game g1 = new Game("Chess");
        Game g2 = new Game("Chess");
        CardGame cg1 = new CardGame("Poker", 4);
        CardGame cg2 = new CardGame("Poker", 4);

        System.out.println(g1.equals(g2)); // true
        System.out.println(cg1.equals(cg2)); // true
        System.out.println(cg1); // CardGame details
    }
}
