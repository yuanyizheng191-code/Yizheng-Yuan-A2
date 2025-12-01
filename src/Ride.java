import java.util.*;
import java.io.*;

/**
 * Represents an amusement ride in the theme park.
 * Implements RideInterface to provide queue management, ride history, and cycle operation functionality.
 */
public class Ride implements RideInterface {
    private String rideName;               // Name of the ride
    private int maxRider;                  // Part 5: Maximum number of riders per cycle
    private Employee operator;             // Ride operator
    private int numOfCycles;               // Part 5: Cycle counter
    
    // Part 3: Waiting queue for visitors
    private Queue<Visitor> waitingLine;
    // Part 4: Ride history records
    private LinkedList<Visitor> rideHistory;

    /**
     * Default constructor. Creates a ride with default values.
     */
    public Ride() {
        this.rideName = "Unknown Ride";
        this.maxRider = 2;                 // Default 2 riders per cycle
        this.operator = null;
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    /**
     * Constructor with parameters.
     * @param rideName Name of the ride
     * @param maxRider Maximum number of riders per cycle
     * @param operator Ride operator
     */
    public Ride(String rideName, int maxRider, Employee operator) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.operator = operator;
        this.numOfCycles = 0;
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

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public Queue<Visitor> getWaitingLine() {
        return waitingLine;
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getName() : "No operator assigned";
        return "Ride: " + rideName + ", MaxRider: " + maxRider + ", Operator: " + operatorInfo + 
               ", Cycles: " + numOfCycles + ", Waiting: " + waitingLine.size() + " visitors, History: " + rideHistory.size() + " visitors";
    }

    // Part 3: Queue operation methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.add(visitor);
            System.out.println("✓ " + visitor.getName() + " has joined " + rideName + " waiting queue");
        } else {
            System.out.println("✗ Cannot add null visitor to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removed = waitingLine.poll();
            System.out.println("✓ " + removed.getName() + " has been removed from " + rideName + " waiting queue");
        } else {
            System.out.println("✗ " + rideName + " waiting queue is empty, cannot remove visitor");
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
    }

    // Part 4A: History record operation methods
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("✓ " + visitor.getName() + " has been added to " + rideName + " ride history");
        } else {
            System.out.println("✗ Cannot add null visitor to history");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("✗ Visitor object to check is null");
            return false;
        }
        
        boolean found = rideHistory.contains(visitor);
        if (found) {
            System.out.println("✓ " + visitor.getName() + " is in " + rideName + " ride history");
        } else {
            System.out.println("✗ " + visitor.getName() + " is not in " + rideName + " ride history");
        }
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println(rideName + " ride history has " + count + " visitors");
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " ride history is empty");
            return;
        }
        
        System.out.println("=== " + rideName + " Ride History (" + rideHistory.size() + " people) ===");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int position = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(position + ". " + visitor);
            position++;
        }
    }

    // Part 4B: Sorting method
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " ride history is empty, no need to sort");
            return;
        }
        
        Collections.sort(rideHistory, comparator);
        System.out.println("✓ " + rideName + " ride history has been sorted");
    }

    // Part 5: Run ride cycle (complete implementation)
    @Override
    public void runOneCycle() {
        System.out.println("\n=== Attempting to run " + rideName + " for one cycle ===");
        
        // Check if there is an operator
        if (operator == null) {
            System.out.println("✗ Cannot run " + rideName + " - no operator assigned");
            return;
        }
        
        // Check if waiting queue is empty
        if (waitingLine.isEmpty()) {
            System.out.println("✗ Cannot run " + rideName + " - waiting queue is empty");
            return;
        }
        
        System.out.println("Operator: " + operator.getName());
        System.out.println("Maximum riders per cycle: " + maxRider);
        System.out.println("Current waiting people: " + waitingLine.size());
        
        int ridersThisCycle = 0;
        List<Visitor> currentRiders = new ArrayList<>();
        
        // Remove up to maxRider visitors from queue
        while (ridersThisCycle < maxRider && !waitingLine.isEmpty()) {
            Visitor rider = waitingLine.poll();
            currentRiders.add(rider);
            ridersThisCycle++;
            System.out.println("  ✓ " + rider.getName() + " is riding " + rideName);
        }
        
        // Add visitors to history
        for (Visitor rider : currentRiders) {
            addVisitorToHistory(rider);
        }
        
        // Update cycle counter
        numOfCycles++;
        
        System.out.println("Riders this cycle: " + ridersThisCycle);
        System.out.println("Total cycles run: " + numOfCycles);
        System.out.println("Remaining waiting people: " + waitingLine.size());
        System.out.println("✓ " + rideName + " cycle completed");
    }

    // Part 6 & 7 method placeholders
    public void exportRideHistory(String filename) {
        System.out.println("exportRideHistory method will be implemented in Part 6");
    }

    public void importRideHistory(String filename) {
        System.out.println("importRideHistory method will be implemented in Part 7");
    }
}