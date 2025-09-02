// Program: Library Book Management System
import java.util.Scanner;

class Book {
    private String bookId, title, author;
    private boolean isAvailable;

    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int bookCounter = 1;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.bookId = generateBookId();
        totalBooks++;
        availableBooks++;
    }

    private static String generateBookId() {
        return String.format("B%03d", bookCounter++);
    }

    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            System.out.println("Book " + bookId + " issued successfully!");
        } else {
            System.out.println("Book already issued!");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
            System.out.println("Book " + bookId + " returned successfully!");
        } else {
            System.out.println("Book was not issued!");
        }
    }

    public void displayBookInfo() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }

    public static void displayStats() {
        System.out.println("Total Books: " + totalBooks + ", Available: " + availableBooks);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBookId() {
        return bookId;
    }
}

class Member {
    private String memberId, memberName;
    private String[] booksIssued;
    private int bookCount;

    private static int memberCounter = 1;

    public Member(String name, int maxBooks) {
        this.memberName = name;
        this.memberId = "M" + (memberCounter++);
        this.booksIssued = new String[maxBooks];
        this.bookCount = 0;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable() && bookCount < booksIssued.length) {
            book.issueBook();
            booksIssued[bookCount++] = book.getBookId();
            System.out.println(memberName + " borrowed " + book.getBookId());
        } else {
            System.out.println("Cannot borrow book!");
        }
    }

    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book b : books) {
                    if (b.getBookId().equals(bookId)) {
                        b.returnBook();
                        break;
                    }
                }
                booksIssued[i] = booksIssued[bookCount - 1];
                booksIssued[--bookCount] = null;
                System.out.println(memberName + " returned " + bookId);
                return;
            }
        }
        System.out.println("Book not found in issued list!");
    }

    public void displayMemberInfo() {
        System.out.print("Member ID: " + memberId + ", Name: " + memberName + ", Books Issued: ");
        for (int i = 0; i < bookCount; i++) {
            System.out.print(booksIssued[i] + " ");
        }
        System.out.println();
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create books
        Book[] books = new Book[3];
        books[0] = new Book("Java Programming", "James Gosling");
        books[1] = new Book("C++ Basics", "Bjarne Stroustrup");
        books[2] = new Book("Python Guide", "Guido van Rossum");

        // Create member
        Member m1 = new Member("Alice", 2);

        // Transactions
        m1.borrowBook(books[0]);
        m1.borrowBook(books[1]);
        m1.displayMemberInfo();
        books[0].displayBookInfo();
        Book.displayStats();

        m1.returnBook("B001", books);
        m1.displayMemberInfo();
        Book.displayStats();

        sc.close();
    }
}
