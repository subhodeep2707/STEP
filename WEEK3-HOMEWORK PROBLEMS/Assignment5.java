// Assignment 5: Library Management System with Fine Calculation
import java.util.*;
class Book {
    String bookId;
    String title;
    String author;
    String isbn;
    String category;
    boolean isIssued;
    String issueDate;
    String dueDate;
    static int totalBooks=0;
    static int totalMembers=0;
    static String libraryName="";
    static double finePerDay=2.0;
    static int maxBooksAllowed=3;
    public Book(String id,String t,String a,String i,String c){ bookId=id; title=t; author=a; isbn=i; category=c; isIssued=false; issueDate=""; dueDate=""; totalBooks++; }
}
class Member {
    String memberId;
    String memberName;
    String memberType;
    Book[] booksIssued;
    double totalFines;
    String membershipDate;
    public Member(String id,String name,String type,String date){ memberId=id; memberName=name; memberType=type; booksIssued=new Book[Book.maxBooksAllowed]; totalFines=0.0; membershipDate=date; Book.totalMembers++; }
    public boolean issueBook(Book b,String issue,String due){ if(b.isIssued) return false; int idx=-1; for(int i=0;i<booksIssued.length;i++){ if(booksIssued[i]==null){ idx=i; break; } } if(idx==-1) return false; b.isIssued=true; b.issueDate=issue; b.dueDate=due; booksIssued[idx]=b; return true; }
    public int parseDay(String d){ if(d==null||d.length()<10) return 0; return Integer.parseInt(d.substring(8,10)); }
    public double calculateFine(Book b,String actualReturnDate){ int due=parseDay(b.dueDate); int act=parseDay(actualReturnDate); int late=act-due; if(late<=0) return 0.0; return late*Book.finePerDay; }
    public boolean returnBook(String bookId,String actualReturnDate){ for(int i=0;i<booksIssued.length;i++){ if(booksIssued[i]!=null && booksIssued[i].bookId.equals(bookId)){ double fine=calculateFine(booksIssued[i],actualReturnDate); totalFines+=fine; booksIssued[i].isIssued=false; booksIssued[i].issueDate=""; booksIssued[i].dueDate=""; booksIssued[i]=null; return true; } } return false; }
    public boolean renewBook(String bookId,String newDueDate){ for(int i=0;i<booksIssued.length;i++){ if(booksIssued[i]!=null && booksIssued[i].bookId.equals(bookId)){ booksIssued[i].dueDate=newDueDate; return true; } } return false; }
    public Book searchBooks(Book[] catalog,String keyword){ for(Book b:catalog){ if(b!=null && (b.title.contains(keyword)||b.author.contains(keyword))) return b; } return null; }
    public boolean reserveBook(Book b){ return !b.isIssued; }
}
class LibraryReports {
    public static String generateLibraryReport(Book[] catalog,Member[] members){ int issued=0; for(Book b:catalog){ if(b!=null && b.isIssued) issued++; } return "Books:"+Book.totalBooks+" Members:"+Book.totalMembers+" Issued:"+issued; }
    public static Book[] getOverdueBooks(Book[] catalog){ ArrayList<Book> list=new ArrayList<>(); for(Book b:catalog){ if(b!=null && b.isIssued) list.add(b); } return list.toArray(new Book[0]); }
    public static Book[] getMostPopularBooks(Book[] catalog){ return catalog; }
}
class Assignment5 {
    public static void main(String[] args){
        Book.libraryName="City Library"; Book.finePerDay=5.0; Book.maxBooksAllowed=3;
        Book[] catalog=new Book[10];
        catalog[0]=new Book("B1","DSA","Yash","111","CS");
        catalog[1]=new Book("B2","Math","RD","222","Math");
        catalog[2]=new Book("B3","History","AB","333","Arts");
        Member m=new Member("M1","Sara","Student","2025-01-01");
        m.issueBook(catalog[0],"2025-08-01","2025-08-10");
        m.renewBook("B1","2025-08-12");
        m.returnBook("B1","2025-08-15");
        System.out.println(LibraryReports.generateLibraryReport(catalog,new Member[]{m}));
        System.out.println(m.totalFines);
    }
}

