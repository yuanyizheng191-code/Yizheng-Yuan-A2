import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Main test class for the Theme Park Visitor Management System.
 * This class demonstrates all functionality through a series of test methods.
 */
public class AssignmentTwo {
    /**
     * Main method that runs all test scenarios.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        
        System.out.println("=== Theme Park Visitor Management System - Complete Test ===\n");
        
        // Run all test parts sequentially
        assignment.partThree();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        assignment.partFourA();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        assignment.partFourB();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        assignment.partFive();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        assignment.partSix();
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        assignment.partSeven();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== All Tests Completed ===");
    }
    
    /**
     * Part 3: Testing the waiting queue functionality of rides.
     * Demonstrates adding visitors to queue, printing queue, and removing visitors.
     */
    public void partThree() {
        System.out.println("=== Part 3: Waiting Queue Test ===");
        
        Employee operator = new Employee("John Operator", 30, "EMP001", "OP001", "Ride Operations");
        Ride rollerCoaster = new Ride("Super Coaster", 2, operator);
        
        Visitor visitor1 = new Visitor("Zhang San", 25, "V001", "T001", "Gold");
        Visitor visitor2 = new Visitor("Li Si", 30, "V002", "T002", "Silver");
        Visitor visitor3 = new Visitor("Wang Wu", 22, "V003", "T003", "Standard");
        Visitor visitor4 = new Visitor("Zhao Liu", 28, "V004", "T004", "Gold");
        Visitor visitor5 = new Visitor("Qian Qi", 35, "V005", "T005", "Standard");
        
        System.out.println("=== Adding 5 visitors to queue ===");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        
        System.out.println("\n=== Printing current queue ===");
        rollerCoaster.printQueue();
        
        System.out.println("\n=== Removing one visitor from queue ===");
        rollerCoaster.removeVisitorFromQueue();
        
        System.out.println("\n=== Printing queue after removal ===");
        rollerCoaster.printQueue();
    }
    
    /**
     * Part 4A: Testing ride history functionality.
     * Demonstrates adding visitors to history, checking visitors in history,
     * counting visitors, and printing history.
     */
    public void partFourA() {
        System.out.println("=== Part 4A: Ride History Test ===");
        
        Employee operator = new Employee("Sarah Operator", 28, "EMP002", "OP002", "Ride Operations");
        Ride waterRide = new Ride("Water Adventure", 4, operator);
        
        Visitor visitor1 = new Visitor("Wang Ming", 20, "V006", "T006", "Standard");
        Visitor visitor2 = new Visitor("Li Hua", 32, "V007", "T007", "Gold");
        Visitor visitor3 = new Visitor("Zhang Wei", 27, "V008", "T008", "Silver");
        Visitor visitor4 = new Visitor("Liu Fang", 24, "V009", "T009", "Standard");
        Visitor visitor5 = new Visitor("Chen Jing", 29, "V010", "T010", "Gold");
        
        System.out.println("=== Adding 5 visitors to ride history ===");
        waterRide.addVisitorToHistory(visitor1);
        waterRide.addVisitorToHistory(visitor2);
        waterRide.addVisitorToHistory(visitor3);
        waterRide.addVisitorToHistory(visitor4);
        waterRide.addVisitorToHistory(visitor5);
        
        System.out.println("\n=== Checking if visitors are in history ===");
        waterRide.checkVisitorFromHistory(visitor2);
        waterRide.checkVisitorFromHistory(new Visitor("Unknown Visitor", 0, "V999", "T999", "Standard"));
        
        System.out.println("\n=== Printing visitor count ===");
        waterRide.numberOfVisitors();
        
        System.out.println("\n=== Printing ride history using Iterator ===");
        waterRide.printRideHistory();
    }
    
    /**
     * Part 4B: Testing ride history sorting functionality.
     * Demonstrates adding visitors to history and sorting them using VisitorComparator.
     */
    public void partFourB() {
        System.out.println("=== Part 4B: Ride History Sorting Test ===");
        
        Employee operator = new Employee("Mike Operator", 35, "EMP003", "OP003", "Ride Operations");
        Ride ferrisWheel = new Ride("Ferris Wheel", 6, operator);
        
        Visitor visitor1 = new Visitor("Zhang San", 25, "V011", "T011", "Standard");
        Visitor visitor2 = new Visitor("Li Si", 30, "V012", "T012", "Gold");
        Visitor visitor3 = new Visitor("Zhang San", 20, "V013", "T013", "Silver");
        Visitor visitor4 = new Visitor("Wang Wu", 28, "V014", "T014", "Standard");
        Visitor visitor5 = new Visitor("Li Si", 25, "V015", "T015", "Gold");
        
        System.out.println("=== Adding 5 visitors to ride history ===");
        ferrisWheel.addVisitorToHistory(visitor1);
        ferrisWheel.addVisitorToHistory(visitor2);
        ferrisWheel.addVisitorToHistory(visitor3);
        ferrisWheel.addVisitorToHistory(visitor4);
        ferrisWheel.addVisitorToHistory(visitor5);
        
        System.out.println("\n=== Printing ride history before sorting ===");
        ferrisWheel.printRideHistory();
        
        System.out.println("\n=== Creating Comparator and sorting ===");
        VisitorComparator comparator = new VisitorComparator();
        ferrisWheel.sortRideHistory(comparator);
        
        System.out.println("\n=== Printing ride history after sorting ===");
        ferrisWheel.printRideHistory();
    }
    
    /**
     * Part 5: Testing ride cycle operation functionality.
     * Demonstrates adding visitors to queue, running ride cycles,
     * and tracking waiting line and ride history.
     */
    public void partFive() {
        System.out.println("=== Part 5: Ride Cycle Operation Test ===");
        
        Employee operator = new Employee("Lisa Operator", 26, "EMP004", "OP004", "Ride Operations");
        Ride carousel = new Ride("Carousel", 3, operator);
        
        System.out.println("=== Adding 10 visitors to waiting queue ===");
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20 + i, "V" + (100 + i), "T" + (100 + i), 
                                         i % 3 == 0 ? "Gold" : i % 3 == 1 ? "Silver" : "Standard");
            carousel.addVisitorToQueue(visitor);
        }
        
        System.out.println("\n=== Printing waiting queue before running ===");
        carousel.printQueue();
        
        System.out.println("\n=== Running first cycle ===");
        carousel.runOneCycle();
        
        System.out.println("\n=== Printing waiting queue after first cycle ===");
        carousel.printQueue();
        
        System.out.println("\n=== Printing ride history after first cycle ===");
        carousel.printRideHistory();
        
        System.out.println("\n=== Running second cycle ===");
        carousel.runOneCycle();
        
        System.out.println("\n=== Printing final status ===");
        System.out.println("Total cycles run: " + carousel.getNumOfCycles());
        System.out.println("Remaining waiting: " + carousel.getWaitingLine().size() + " people");
        System.out.println("History records: " + carousel.getRideHistory().size() + " people");
    }
    
    /**
     * Part 6: Testing ride history export functionality.
     * Demonstrates adding visitors to history and exporting to CSV file.
     */
    public void partSix() {
        System.out.println("=== Part 6: Export Ride History to File ===");
        
        Employee operator = new Employee("David Operator", 33, "EMP005", "OP005", "Ride Operations");
        Ride spaceRide = new Ride("Space Adventure", 4, operator);
        
        System.out.println("=== Creating and adding 5 visitors to ride history ===");
        Visitor visitor1 = new Visitor("Emma", 23, "V101", "T101", "Gold");
        Visitor visitor2 = new Visitor("Liam", 31, "V102", "T102", "Silver");
        Visitor visitor3 = new Visitor("Olivia", 26, "V103", "T103", "Standard");
        Visitor visitor4 = new Visitor("Noah", 29, "V104", "T104", "Gold");
        Visitor visitor5 = new Visitor("Ava", 24, "V105", "T105", "Standard");
        
        spaceRide.addVisitorToHistory(visitor1);
        spaceRide.addVisitorToHistory(visitor2);
        spaceRide.addVisitorToHistory(visitor3);
        spaceRide.addVisitorToHistory(visitor4);
        spaceRide.addVisitorToHistory(visitor5);
        
        System.out.println("\n=== Displaying current ride history ===");
        spaceRide.printRideHistory();
        
        System.out.println("\n=== Exporting ride history to file ===");
        String filename = "space_ride_history.csv";
        spaceRide.exportRideHistory(filename);
        
        System.out.println("\n=== Verifying if file was created successfully ===");
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("✓ File created successfully: " + file.getAbsolutePath());
        }
    }
    
    /**
     * Part 7: Testing ride history import functionality.
     * Demonstrates creating test data file and importing ride history from CSV.
     */
    public void partSeven() {
        System.out.println("=== Part 7: Import Ride History from File ===");
        
        // First create a test file
        System.out.println("=== Creating test data file ===");
        createTestDataFile();
        
        // Create new ride (initially empty)
        System.out.println("\n=== Creating new ride ===");
        Ride newRide = new Ride("New Ride", 4, null);
        System.out.println("Initial history record count: " + newRide.getRideHistory().size());
        
        // Import file
        System.out.println("\n=== Importing ride history from file ===");
        newRide.importRideHistory("test_import_data.csv");
        
        // Verify import results
        System.out.println("\n=== Verifying import results ===");
        newRide.numberOfVisitors();
        
        System.out.println("\n=== Printing imported ride history ===");
        newRide.printRideHistory();
    }
    
    /**
     * Helper method to create a test data CSV file for import testing.
     * Creates a file with visitor data in CSV format.
     */
    private void createTestDataFile() {
        String filename = "test_import_data.csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Zhang San,25,V201,T201,Gold");
            writer.println("Li Si,30,V202,T202,Silver");
            writer.println("Wang Wu,22,V203,T203,Standard");
            writer.println("Zhao Liu,28,V204,T204,Gold");
            writer.println("Qian Qi,35,V205,T205,Standard");
            System.out.println("✓ Test file created: " + filename);
        } catch (Exception e) {
            System.out.println("✗ Failed to create test file: " + e.getMessage());
        }
    }
}