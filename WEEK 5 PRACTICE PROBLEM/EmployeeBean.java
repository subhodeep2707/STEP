import java.io.Serializable;
import java.util.Date;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {}
    public EmployeeBean(String employeeId, String firstName, String lastName,
                        double salary, String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public Date getHireDate() { return hireDate; }
    public boolean isActive() { return isActive; }

    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSalary(double salary) { if (salary >= 0) this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    public void setActive(boolean active) { isActive = active; }

    public String getFullName() { return firstName + " " + lastName; }

    @Override
    public String toString() {
        return employeeId + " - " + getFullName() + " | " + department + " | " + salary;
    }
}
