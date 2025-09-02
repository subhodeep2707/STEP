// Assignment 4: Student Grade Management System
import java.util.*;
class Subject {
    String subjectCode;
    String subjectName;
    int credits;
    String instructor;
    public Subject(String c,String n,int cr,String ins){ subjectCode=c; subjectName=n; credits=cr; instructor=ins; }
}
class Student {
    String studentId;
    String studentName;
    String className;
    String[] subjects;
    double[][] marks;
    double gpa;
    static int totalStudents=0;
    static String schoolName="";
    static String[] gradingScale = new String[]{"A","B","C","D","F"};
    static double passPercentage=40.0;
    public Student(String id,String name,String cls,String[] subjects,int exams){
        this.studentId=id; this.studentName=name; this.className=cls; this.subjects=subjects; this.marks=new double[subjects.length][exams]; this.gpa=0.0; totalStudents++;
    }
    public void addMarks(String subject,double mark){ int idx=-1; for(int i=0;i<subjects.length;i++){ if(subjects[i].equals(subject)) idx=i; } if(idx!=-1){ for(int j=0;j<marks[idx].length;j++){ if(marks[idx][j]==0){ marks[idx][j]=mark; break; } } }
    }
    public void calculateGPA(){ double sum=0; int cnt=0; for(int i=0;i<marks.length;i++){ for(int j=0;j<marks[i].length;j++){ sum+=marks[i][j]; cnt++; } } double avg=(cnt==0)?0:sum/cnt; gpa = avg/10.0; }
    public String gradeFor(double percent){ if(percent>=85) return gradingScale[0]; if(percent>=70) return gradingScale[1]; if(percent>=55) return gradingScale[2]; if(percent>=40) return gradingScale[3]; return gradingScale[4]; }
    public String generateReportCard(){ StringBuilder sb=new StringBuilder(); sb.append(studentId+" "+studentName+" "+className+"\n"); for(int i=0;i<subjects.length;i++){ double s=0; int c=0; for(int j=0;j<marks[i].length;j++){ s+=marks[i][j]; if(marks[i][j]>0) c++; } double p=(c==0)?0:(s/c); sb.append(subjects[i]+" "+p+" "+gradeFor(p)+"\n"); } sb.append("GPA "+gpa+"\n"); return sb.toString(); }
    public boolean checkPromotionEligibility(){ for(int i=0;i<subjects.length;i++){ double s=0; int c=0; for(int j=0;j<marks[i].length;j++){ s+=marks[i][j]; if(marks[i][j]>0) c++; } double p=(c==0)?0:(s/c); if(p<passPercentage) return false; } return true; }
    public static void setGradingScale(String[] scale){ gradingScale=scale; }
    public static double calculateClassAverage(Student[] students){ double sum=0; int cnt=0; for(Student st:students){ if(st!=null){ for(int i=0;i<st.marks.length;i++){ for(int j=0;j<st.marks[i].length;j++){ sum+=st.marks[i][j]; cnt++; } } } } return cnt==0?0:sum/cnt; }
    public static Student[] getTopPerformers(Student[] students,int count){ ArrayList<Student> list=new ArrayList<>(); for(Student s:students){ if(s!=null){ s.calculateGPA(); list.add(s); } } Collections.sort(list,new Comparator<Student>(){ public int compare(Student a,Student b){ return Double.compare(b.gpa,a.gpa); } }); if(count>list.size()) count=list.size(); return list.subList(0,count).toArray(new Student[0]); }
    public static String generateSchoolReport(){ return "Total Students "+totalStudents+" School "+schoolName; }
}
class Assignment4 {
    public static void main(String[] args){
        Student.schoolName="SRM School";
        String[] subs=new String[]{"Math","Physics","Chemistry"};
        Student s1=new Student("S1","Neha","X-A",subs,3);
        Student s2=new Student("S2","Arjun","X-A",subs,3);
        s1.addMarks("Math",90); s1.addMarks("Physics",80); s1.addMarks("Chemistry",85);
        s1.addMarks("Math",88); s1.addMarks("Physics",76); s1.addMarks("Chemistry",91);
        s2.addMarks("Math",60); s2.addMarks("Physics",55); s2.addMarks("Chemistry",65);
        s1.calculateGPA(); s2.calculateGPA();
        System.out.println(s1.generateReportCard());
        System.out.println(s2.generateReportCard());
        System.out.println(Student.calculateClassAverage(new Student[]{s1,s2}));
        Student[] tops=Student.getTopPerformers(new Student[]{s1,s2},1); System.out.println(tops[0].studentName);
        System.out.println(s1.checkPromotionEligibility());
        System.out.println(Student.generateSchoolReport());
    }
}

