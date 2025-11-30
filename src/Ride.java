import java.util.*;

/**
 * Ride class that implements RideInterface.
 * Represents an amusement park ride with waiting queue and ride history functionality.
 */
public class Ride implements RideInterface {
    private String rideName;         // Name of the ride
    private int maxRider;            // Maximum number of riders per cycle
    private Employee operator;       // Employee operating the ride
    private int numOfCycles;         // Number of ride cycles completed
    
    // Part 3: Waiting queue for visitors
    private Queue<Visitor> waitingLine;
    // Part 4: History of visitors who have ridden
    private LinkedList<Visitor> rideHistory;

    /**
     * Default constructor that creates a ride with default values.
     */
    public Ride() {
        this.rideName = "Unknown Ride";
        this.maxRider = 2;
        this.operator = null;
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    /**
     * Parameterized constructor that creates a ride with specified values.
     * 
     * @param rideName name of the ride
     * @param maxRider maximum number of riders per cycle
     * @param operator employee operating the ride
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

    /**
     * Returns a string representation of the ride.
     * 
     * @return string with ride details including name, capacity, operator, cycles, and queue/history information
     */
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
            System.out.println("✓ " + visitor.getName() + " has joined the waiting queue for " + rideName);
        } else {
            System.out.println("✗ Cannot add null visitor to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removed = waitingLine.poll();
            System.out.println("✓ " + removed.getName() + " has been removed from the waiting queue for " + rideName);
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
    }

    // ==================== Part 4A: History operation methods ====================
    
    /**
     * Adds a visitor to the ride history.
     * 
     * @param visitor the visitor to add to history
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("✓ " + visitor.getName() + " has been added to " + rideName + " ride history");
        } else {
            System.out.println("✗ Cannot add null visitor to history");
        }
    }

    /**
     * Checks if a visitor exists in the ride history.
     * 
     * @param visitor the visitor to check
     * @return true if visitor is found in history, false otherwise
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("✗ The visitor object to check is null");
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

    /**
     * Returns the number of visitors in the ride history.
     * 
     * @return count of visitors in history
     */
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println(rideName + " ride history contains " + count + " visitors");
        return count;
    }

    /**
     * Prints the ride history using an Iterator as required.
     */
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " ride history is empty");
            return;
        }
        
        System.out.println("=== " + rideName + " Ride History (" + rideHistory.size() + " people) ===");
        // Using Iterator to traverse as required by assignment
        Iterator<Visitor> iterator = rideHistory.iterator();
        int position = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(position + ". " + visitor);
            position++;
        }
    }

    // ==================== Part 4B: Sorting methods ====================
    
    /**
     * Sorts the ride history using the provided comparator.
     * 
     * @param comparator the comparator to use for sorting
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.isEmpty()) {
            System.out.println(rideHistory + " ride history is empty, no sorting needed");
            return;
        }
        
        System.out.println("Sorting " + rideName + " ride history...");
        Collections.sort(rideHistory, comparator);
        System.out.println("✓ " + rideName + " ride history has been sorted successfully");
    }

    // Reserved method for future part
    @Override
    public void runOneCycle() {
        System.out.println("runOneCycle method will be implemented in Part 5");
    }
}