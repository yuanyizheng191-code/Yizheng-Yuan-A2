import java.util.LinkedList;

/**
 * AssignmentTwo class that contains test methods for different parts
 * of the Theme Park Visitor Management System.
 * This class demonstrates the functionality of ride history management and sorting.
 */
public class AssignmentTwo {
    /**
     * Main method that runs the Part 4 tests for ride history and sorting.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        
        System.out.println("=== Part 4: Ride History and Sorting Test ===\n");
        
        assignment.partFourA();
        System.out.println("\n" + "=".repeat(60) + "\n");
        assignment.partFourB();
    }
    
    /**
     * Tests the LinkedList implementation for ride history functionality.
     * Demonstrates adding visitors to history, checking visitor presence,
     * counting visitors, and printing history using Iterator.
     */
    public void partFourA() {
        System.out.println("=== Part 4A: Ride History LinkedList Test ===");
        
        // Create operator
        Employee operator = new Employee("Sarah Operator", 28, "EMP002", "OP002", "Ride Operations");
        
        // Create ride
        Ride waterRide = new Ride("Water Adventure", 4, operator);
        
        // Create 5 visitors
        Visitor visitor1 = new Visitor("Wang Ming", 20, "V006", "T006", "Standard");
        Visitor visitor2 = new Visitor("Li Hua", 32, "V007", "T007", "Gold");
        Visitor visitor3 = new Visitor("Zhang Wei", 27, "V008", "T008", "Silver");
        Visitor visitor4 = new Visitor("Liu Fang", 24, "V009", "T009", "Standard");
        Visitor visitor5 = new Visitor("Chen Jing", 29, "V010", "T010", "Gold");
        
        System.out.println("=== Step 1: Add 5 visitors to ride history ===");
        waterRide.addVisitorToHistory(visitor1);
        waterRide.addVisitorToHistory(visitor2);
        waterRide.addVisitorToHistory(visitor3);
        waterRide.addVisitorToHistory(visitor4);
        waterRide.addVisitorToHistory(visitor5);
        
        System.out.println("\n=== Step 2: Check if visitors are in history ===");
        waterRide.checkVisitorFromHistory(visitor2);
        waterRide.checkVisitorFromHistory(new Visitor("Unknown Visitor", 0, "V999", "T999", "Standard"));
        
        System.out.println("\n=== Step 3: Print visitor count ===");
        waterRide.numberOfVisitors();
        
        System.out.println("\n=== Step 4: Print ride history using Iterator ===");
        waterRide.printRideHistory();
        
        System.out.println("\n=== Step 5: Test edge cases ===");
        // Test adding null visitor
        waterRide.addVisitorToHistory(null);
        
        // Test checking null visitor
        waterRide.checkVisitorFromHistory(null);
        
        // Test printing empty history
        Ride emptyRide = new Ride("Empty Ride", 2, operator);
        emptyRide.printRideHistory();
        
        System.out.println("\n=== Part 4A Test Completed ===");
    }
    
    /**
     * Tests the sorting functionality for ride history using VisitorComparator.
     * Demonstrates sorting visitors by name (case-insensitive) and age,
     * and validates the sorting results.
     */
    public void partFourB() {
        System.out.println("=== Part 4B: Sorting Ride History Test ===");
        
        // Create operator
        Employee operator = new Employee("Mike Operator", 35, "EMP003", "OP003", "Ride Operations");
        
        // Create ride
        Ride ferrisWheel = new Ride("Ferris Wheel", 6, operator);
        
        // Create visitors (deliberately creating some visitors with same name but different age)
        Visitor visitor1 = new Visitor("Zhang San", 25, "V011", "T011", "Standard");
        Visitor visitor2 = new Visitor("Li Si", 30, "V012", "T012", "Gold");
        Visitor visitor3 = new Visitor("Zhang San", 20, "V013", "T013", "Silver"); // Same name, different age
        Visitor visitor4 = new Visitor("Wang Wu", 28, "V014", "T014", "Standard");
        Visitor visitor5 = new Visitor("Li Si", 25, "V015", "T015", "Gold"); // Same name, different age
        Visitor visitor6 = new Visitor("alice", 22, "V016", "T016", "Standard"); // Test case sensitivity
        Visitor visitor7 = new Visitor("Alice", 26, "V017", "T017", "Gold"); // Test case sensitivity
        
        System.out.println("=== Step 1: Add visitors to ride history ===");
        ferrisWheel.addVisitorToHistory(visitor1);
        ferrisWheel.addVisitorToHistory(visitor2);
        ferrisWheel.addVisitorToHistory(visitor3);
        ferrisWheel.addVisitorToHistory(visitor4);
        ferrisWheel.addVisitorToHistory(visitor5);
        ferrisWheel.addVisitorToHistory(visitor6);
        ferrisWheel.addVisitorToHistory(visitor7);
        
        System.out.println("\n=== Step 2: Print ride history before sorting ===");
        ferrisWheel.printRideHistory();
        
        System.out.println("\n=== Step 3: Create Comparator and sort ===");
        // Create Comparator and sort
        VisitorComparator comparator = new VisitorComparator();
        System.out.println("Using sorter: " + comparator);
        ferrisWheel.sortRideHistory(comparator);
        
        System.out.println("\n=== Step 4: Print ride history after sorting ===");
        // Print sorted history
        ferrisWheel.printRideHistory();
        
        System.out.println("\n=== Step 5: Validate sorting results ===");
        System.out.println("Sorting validation:");
        LinkedList<Visitor> sortedHistory = ferrisWheel.getRideHistory();
        for (int i = 0; i < sortedHistory.size() - 1; i++) {
            Visitor current = sortedHistory.get(i);
            Visitor next = sortedHistory.get(i + 1);
            
            int nameCompare = current.getName().compareToIgnoreCase(next.getName());
            if (nameCompare > 0) {
                System.out.println("✗ Sorting error: " + current.getName() + " should come before " + next.getName());
            } else if (nameCompare == 0 && current.getAge() > next.getAge()) {
                System.out.println("✗ Sorting error: " + current.getName() + "(" + current.getAge() + 
                                 ") should come after " + next.getName() + "(" + next.getAge() + ")");
            } else {
                System.out.println("✓ Order correct: " + current.getName() + "(" + current.getAge() + 
                                 ") -> " + next.getName() + "(" + next.getAge() + ")");
            }
        }
        
        System.out.println("\n=== Testing edge case: Sorting empty history ===");
        Ride emptyRide = new Ride("Empty Ride", 4, operator);
        emptyRide.sortRideHistory(comparator);
        
        System.out.println("\n=== Part 4B Test Completed ===");
    }
    
    // Reserved methods for other parts
    public void partThree() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}