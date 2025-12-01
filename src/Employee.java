/**
 * Class representing an employee in the theme park system.
 * Extends the Person class with employee-specific properties.
 */
public class Employee extends Person {
    private String employeeId;
    private String department;

    /**
     * Default constructor initializes employee with default values.
     * Sets employee ID and department to "Unknown".
     */
    public Employee() {
        super();
        this.employeeId = "Unknown";
        this.department = "Unknown";
    }

    /**
     * Parameterized constructor to create an employee with specific details.
     * 
     * @param name The employee's name
     * @param age The employee's age
     * @param id The employee's personal identifier
     * @param employeeId The employee's work identifier
     * @param department The department the employee works in
     */
    public Employee(String name, int age, String id, String employeeId, String department) {
        super(name, age, id);
        this.employeeId = employeeId;
        this.department = department;
    }

    /**
     * Getter and Setter methods
     */
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

    /**
     * Returns a string representation of the employee.
     * 
     * @return A formatted string including parent class details plus employee ID and department information
     */
    @Override
    public String toString() {
        return super.toString() + ", Employee ID: " + employeeId + ", Department: " + department;
    }
}