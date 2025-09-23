class Box {
    public void pack() {
        System.out.println("Packing items in a box...");
    }

    public void unpack() {
        System.out.println("Unpacking items from the box...");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack(); // call parent method first
        System.out.println("Adding ribbons and wrapping for the gift.");
    }

    @Override
    public void unpack() {
        super.unpack(); // call parent method first
        System.out.println("Removing gift wrapping and ribbons.");
    }
}

public class Lab6 {
    public static void main(String[] args) {
        GiftBox g = new GiftBox();
        g.pack();
        g.unpack();
    }
}
