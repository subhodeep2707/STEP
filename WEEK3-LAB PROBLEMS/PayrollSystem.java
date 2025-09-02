// Program: Employee Payroll System
class Employee {
    private String empId, empName, department, empType;
    private double baseSalary;

    private static int totalEmployees = 0;
    private static int empCounter = 1;

    // Constructor for full-time employee
    public Employee(String name, String dept, double baseSalary) {
        this.empName = name;
        this.department = dept;
        this.baseSalary = baseSalary;
        this.empType = "Full-Time";
        this.empId = "E" + (empCounter++);
        totalEmployees++;
    }

    // Constructor for part-time employee
    public Employee(String name, String dept, double hourlyRate, int hours) {
        this.empName = name;
        this.department = dept;
        this.baseSalary = hourlyRate * hours;
        this.empType = "Part-Time";
        this.empId = "E" + (empCounter++);
        totalEmployees++;
    }

    // Constructor for contract employee
    public Employee(String name, String dept, double contractAmount, boolean contract) {
        this.empName = name;
        this.department = dept;
        this.baseSalary = contractAmount;
        this.empType = "Contract";
        this.empId = "E" + (empCounter++);
        totalEmployees++;
    }

    // Calculate Salary
    public double calculateSalary() {
        if (empType.equals("Full-Time")) return baseSalary + 5000; // bonus
        else if (empType.equals("Part-Time")) return baseSalary;
        else return baseSalary; // contract fixed
    }

    // Calculate Tax
    public double calculateTax() {
        if (empType.equals("Full-Time")) return calculateSalary() * 0.1;
        else if (empType.equals("Part-Time")) return calculateSalary() * 0.05;
        else return calculateSalary() * 0.08;
    }

    // Generate PaySlip
    public void generatePaySlip() {
        System.out.println("----- Pay Slip -----");
        System.out.println("Emp ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Type: " + empType);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("Tax: " + calculateTax());
        System.out.println("---------------------");
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "IT", 50000); // Full-time
        Employee e2 = new Employee("Sara", "HR", 200, 40); // Part-time
        Employee e3 = new Employee("Mike", "Finance", 60000, true); // Contract

        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();

        System.out.println("Total Employees: " + Employee.getTotalEmployees());
    }
}
