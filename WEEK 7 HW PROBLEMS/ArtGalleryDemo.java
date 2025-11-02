// File: ArtGalleryDemo.java
class Artwork {
    public void display() {
        System.out.println("General artwork display.");
    }
}

class Painting extends Artwork {
    public void showPalette() {
        System.out.println("Painting: Displaying color palette and brush technique.");
    }
}

public class ArtGalleryDemo {
    public static void main(String[] args) {
        Artwork art = new Painting(); // upcast
        art.display();

        // Downcasting to access specific features
        if (art instanceof Painting) {
            Painting p = (Painting) art;
            p.showPalette();
        }
    }
}
