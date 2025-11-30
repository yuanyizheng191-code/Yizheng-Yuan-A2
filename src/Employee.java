public class Employee extends Person {
    private String employeeId;
    private String department;

    public Employee() {
        super();
        this.employeeId = "Unknown";
        this.department = "Unknown";
    }

    public Employee(String name, int age, String id, String employeeId, String department) {
        super(name, age, id);
        this.employeeId = employeeId;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee ID: " + employeeId + ", Department: " + department;
    }
}