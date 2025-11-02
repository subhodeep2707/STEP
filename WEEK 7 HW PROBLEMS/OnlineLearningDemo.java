// File: OnlineLearningDemo.java
class Course {
    protected String title;
    protected String instructor;

    public Course(String title, String instructor) {
        this.title = title;
        this.instructor = instructor;
    }

    public void showProgress() {
        System.out.println("Generic course progress for " + title);
    }
}

class VideoCourse extends Course {
    private int percent;

    public VideoCourse(String title, String instructor, int percent) {
        super(title, instructor);
        this.percent = percent;
    }

    @Override
    public void showProgress() {
        System.out.println("Video Course: " + title + " watched " + percent + "%");
    }
}

class ReadingCourse extends Course {
    private int pagesRead;

    public ReadingCourse(String title, String instructor, int pagesRead) {
        super(title, instructor);
        this.pagesRead = pagesRead;
    }

    @Override
    public void showProgress() {
        System.out.println("Reading Course: " + title + " pages read = " + pagesRead);
    }
}

public class OnlineLearningDemo {
    public static void main(String[] args) {
        Course c1 = new VideoCourse("Java Basics", "John", 60);
        Course c2 = new ReadingCourse("OOP Concepts", "Alice", 45);

        c1.showProgress();
        c2.showProgress();
    }
}
