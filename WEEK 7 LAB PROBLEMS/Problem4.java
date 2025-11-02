class LibraryUser {
    public void accessLibrary() {
        System.out.println("General library access granted.");
    }
}

class Student extends LibraryUser {
    public void accessLibrary() {
        System.out.println("Student: Borrow books & use computers.");
    }
}

class Faculty extends LibraryUser {
    public void accessLibrary() {
        System.out.println("Faculty: Reserve books & access research databases.");
    }
}

class Guest extends LibraryUser {
    public void accessLibrary() {
        System.out.println("Guest: Only browsing books allowed.");
    }
}

public class Problem4 {
    public static void main(String[] args) {
        LibraryUser u1 = new Student();  // Upcasting
        LibraryUser u2 = new Faculty();  // Upcasting
        LibraryUser u3 = new Guest();    // Upcasting

        u1.accessLibrary();
        u2.accessLibrary();
        u3.accessLibrary();
    }
}
