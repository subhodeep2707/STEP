import java.util.Random;

class MovieTicket {
    private String movieName;
    private String theatreName;
    private int seatNumber;
    private double price;

    // 1) Default → "Unknown" movie
    public MovieTicket() {
        this("Unknown", "PVR", -1, 0.0);
    }

    // 2) Movie name only → default price = 200
    public MovieTicket(String movieName) {
        this(movieName, "PVR", -1, 200.0);
    }

    // 3) Movie name + seat number → default theatre "PVR"
    public MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 200.0);
    }

    // 4) Full constructor
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void printTicket() {
        System.out.printf(" %s @ %s | Seat: %s | ₹%.2f%n",
                movieName, theatreName, seatNumber < 0 ? "TBD" : seatNumber, price);
    }

    // tiny helpers to keep main concise
    private static int A12() { return 12; }
    private static int F7() { return 67; }

    public static void main(String[] args) {
        System.out.println("--- Movie Ticket Booking ---");
        MovieTicket t1 = new MovieTicket();
        MovieTicket t2 = new MovieTicket("Inception");
        MovieTicket t3 = new MovieTicket("Dune: Part Two", A12());
        MovieTicket t4 = new MovieTicket("Interstellar", "INOX", F7(), 350.0);
        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}