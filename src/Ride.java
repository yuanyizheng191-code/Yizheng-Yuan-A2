public class Ride {
    private String rideName;
    private int capacity;
    private Employee operator;

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.capacity = 0;
        this.operator = null;
    }

    // Parameterized constructor
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
    }

    // Getter and Setter methods
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getName() : "No operator assigned";
        return "Ride: " + rideName + ", Capacity: " + capacity + ", Operator: " + operatorInfo;
    }
}