class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Default → empty book
    public Book() {
        this("", "", "", true);
    }

    // Title + author
    public Book(String title, String author) {
        this(title, author, "", true);
    }

    // All details
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (!isAvailable) {
            System.out.println(" ❌  Already borrowed.");
            return;
        }
        isAvailable = false;
        System.out.println(" ✅  Borrowed successfully.");
    }

    public void returnBook() {
        if (isAvailable) {
            System.out.println(" ℹ️  Book was not borrowed.");
            return;
        }
        isAvailable = true;
        System.out.println(" ✅  Returned successfully.");
    }

    public void displayBookInfo() {
        System.out.printf(" 📖  \"%s\" by %s | ISBN: %s | %s%n",
                title, author, isbn.isEmpty() ? "N/A" : isbn, isAvailable ? "Available" : "Not Available");
    }

    public static void main(String[] args) {
        System.out.println("--- Library Book Management ---");
        Book b1 = new Book();
        Book b2 = new Book("Clean Code", "Robert C. Martin");
        Book b3 = new Book("Effective Java", "Joshua Bloch", "9780134685991", true);
        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
        b3.borrowBook();
        b3.displayBookInfo();
        b3.returnBook();
        b3.displayBookInfo();
    }
}