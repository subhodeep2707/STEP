// Assignment 6: Employee Payroll and Attendance System
import java.util.*;
class Employee {
    String empId;
    String empName;
    String department;
    String designation;
    double baseSalary;
    String joinDate;
    boolean[] attendanceRecord;
    String type;
    static int totalEmployees=0;
    static String companyName="";
    static double totalSalaryExpense=0.0;
    static int workingDaysPerMonth=30;
    public Employee(String id,String name,String dept,String desig,double base,String join,String type){ empId=id; empName=name; department=dept; designation=desig; baseSalary=base; joinDate=join; attendanceRecord=new boolean[30]; this.type=type; totalEmployees++; }
    public void markAttendance(int day,boolean present){ if(day>=1 && day<=30) attendanceRecord[day-1]=present; }
    public int presentDays(){ int c=0; for(boolean b:attendanceRecord){ if(b) c++; } return c; }
    public double calculateSalary(){ double ratio=presentDays()*1.0/workingDaysPerMonth; double salary=baseSalary*ratio; if(type.equals("Part-time")) salary*=0.6; else if(type.equals("Contract")) salary*=0.8; return salary+calculateBonus(); }
    public double calculateBonus(){ int p=presentDays(); if(p>=27) return baseSalary*0.1; if(p>=24) return baseSalary*0.05; return 0.0; }
    public String generatePaySlip(){ double pay=calculateSalary(); totalSalaryExpense+=pay; return empId+" "+empName+" "+pay; }
    public boolean requestLeave(){ return true; }
}
class Department {
    String deptId;
    String deptName;
    Employee manager;
    Employee[] employees;
    double budget;
    int size;
    public Department(String id,String name,Employee manager,double budget){ deptId=id; deptName=name; this.manager=manager; this.budget=budget; employees=new Employee[50]; size=0; }
    public void addEmployee(Employee e){ employees[size++]=e; }
}
class HRReports {
    public static double calculateCompanyPayroll(Employee[] emps){ double sum=0; for(Employee e:emps){ if(e!=null) sum+=e.calculateSalary(); } return sum; }
    public static double[] getDepartmentWiseExpenses(Department[] depts){ double[] arr=new double[depts.length]; for(int i=0;i<depts.length;i++){ double s=0; for(int j=0;j<depts[i].size;j++){ s+=depts[i].employees[j].calculateSalary(); } arr[i]=s; } return arr; }
    public static String getAttendanceReport(Employee e){ return e.empId+" Present:"+e.presentDays(); }
}
class Assignment6 {
    public static void main(String[] args){
        Employee.companyName="Google";
        Employee m=new Employee("E0","Manager","IT","Lead",80000,"2025-01-01","Full-time");
        Department d=new Department("D1","IT",m,1000000);
        Employee e1=new Employee("E1","Anil","IT","Dev",50000,"2025-02-01","Full-time");
        Employee e2=new Employee("E2","Juhi","IT","Dev",30000,"2025-03-01","Part-time");
        Employee e3=new Employee("E3","Kia","IT","QA",40000,"2025-03-01","Contract");
        d.addEmployee(e1); d.addEmployee(e2); d.addEmployee(e3);
        for(int i=1;i<=30;i++){ e1.markAttendance(i,true); e2.markAttendance(i,i%2==0); e3.markAttendance(i,i%3!=0); }
        System.out.println(e1.generatePaySlip());
        System.out.println(e2.generatePaySlip());
        System.out.println(e3.generatePaySlip());
        System.out.println(Arrays.toString(HRReports.getDepartmentWiseExpenses(new Department[]{d})));
        System.out.println(HRReports.getAttendanceReport(e3));
    }
}

