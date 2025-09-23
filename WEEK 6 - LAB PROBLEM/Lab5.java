class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public void play() {
        System.out.println(name + " is playing...");
    }
}

class Piano extends Instrument {
    private int keys;

    public Piano(String material, int keys) {
        super("Piano", material);
        this.keys = keys;
    }

    @Override
    public void play() {
        System.out.println(name + " with " + keys + " keys is playing.");
    }
}

class Guitar extends Instrument {
    private int strings;

    public Guitar(String material, int strings) {
        super("Guitar", material);
        this.strings = strings;
    }

    @Override
    public void play() {
        System.out.println(name + " with " + strings + " strings is strumming.");
    }
}

class Drum extends Instrument {
    private int size;

    public Drum(String material, int size) {
        super("Drum", material);
        this.size = size;
    }

    @Override
    public void play() {
        System.out.println(name + " of size " + size + " inches is beating.");
    }
}

public class Lab5 {
    public static void main(String[] args) {
        Instrument[] instruments = {
            new Piano("Wood", 88),
            new Guitar("Steel", 6),
            new Drum("Leather", 20)
        };

        for (Instrument i : instruments) {
            i.play();
        }
    }
}
