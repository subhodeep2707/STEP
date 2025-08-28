public class Student {

    private String studentId;
    private String name;
    private double grade;
    private String course;

    public Student() {
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }

    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    // Method to calculate letter grade
    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade + " (" + calculateLetterGrade() + ")");
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        
        Student s1 = new Student();
        s1.setStudentId("RA24790");
        s1.setName("Shikhar");
        s1.setGrade(78);
        s1.setCourse("Java Programming");
        Student s2 = new Student("RA24791", "Subhodeep", 90, "Step-Java");

        
        s1.displayStudent();
        s2.displayStudent();
    }
}
