import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    
    // Part 3: Waiting queue
    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.capacity = 0;
        this.operator = null;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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

    public Queue<Visitor> getWaitingLine() {
        return waitingLine;
    }

    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getName() : "No operator assigned";
        return "Ride: " + rideName + ", Capacity: " + capacity + ", Operator: " + operatorInfo + 
               ", Waiting: " + waitingLine.size() + " visitors";
    }

    // Part 3: Queue operation methods (Complete implementation)
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.add(visitor);
            System.out.println("✓ " + visitor.getName() + " has joined the waiting queue for " + rideName);
            System.out.println("  Current queue size: " + waitingLine.size());
        } else {
            System.out.println("✗ Cannot add null visitor to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removed = waitingLine.poll();
            System.out.println("✓ " + removed.getName() + " has been removed from the waiting queue for " + rideName);
            System.out.println("  Remaining queue size: " + waitingLine.size());
        } else {
            System.out.println("✗ The waiting queue for " + rideName + " is empty, cannot remove visitor");
        }
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println(rideName + " waiting queue is empty");
            return;
        }
        
        System.out.println("=== " + rideName + " Waiting Queue (" + waitingLine.size() + " people) ===");
        int position = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(position + ". " + visitor);
            position++;
        }
        System.out.println("=== Queue End ===");
    }

    // Part 4: History operation methods (Temporary empty implementation)
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Part 4 implementation
        System.out.println("addVisitorToHistory method will be implemented in Part 4");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // Part 4 implementation
        System.out.println("checkVisitorFromHistory method will be implemented in Part 4");
        return false;
    }

    @Override
    public int numberOfVisitors() {
        // Part 4 implementation
        System.out.println("numberOfVisitors method will be implemented in Part 4");
        return 0;
    }

    @Override
    public void printRideHistory() {
        // Part 4 implementation
        System.out.println("printRideHistory method will be implemented in Part 4");
    }

    // Part 5: Run ride cycle (Temporary empty implementation)
    @Override
    public void runOneCycle() {
        // Part 5 implementation
        System.out.println("runOneCycle method will be implemented in Part 5");
    }
}