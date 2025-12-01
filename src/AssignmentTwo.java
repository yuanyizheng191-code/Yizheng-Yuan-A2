public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        
        System.out.println("=== Theme Park Visitor Management System ===");
        System.out.println("Running Part 5: Ride Cycle Test\n");
        
        assignment.partFive();
    }
    
    public void partFive() {
        System.out.println("=== Part 5: Ride Cycle Test ===");
        
        // Create operator
        Employee operator = new Employee("Lisa Operator", 26, "EMP004", "OP004", "Ride Operations");
        System.out.println("Created operator: " + operator.getName() + "\n");
        
        // Create ride (maximum 3 people per cycle)
        Ride carousel = new Ride("Merry-Go-Round", 3, operator);
        System.out.println("Created ride: " + carousel.getRideName() + " (maximum " + carousel.getMaxRider() + " people per cycle)\n");
        
        // Create 10 visitors
        System.out.println("=== Step 1: Add 10 visitors to waiting queue ===");
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20 + i, "V" + (100 + i), "T" + (100 + i), 
                                         i % 3 == 0 ? "Gold" : i % 3 == 1 ? "Silver" : "Standard");
            carousel.addVisitorToQueue(visitor);
        }
        
        System.out.println("\n=== Step 2: Print waiting queue before operation ===");
        carousel.printQueue();
        
        System.out.println("\n=== Step 3: Run first cycle ===");
        carousel.runOneCycle();
        
        System.out.println("\n=== Step 4: Print waiting queue after first cycle ===");
        carousel.printQueue();
        
        System.out.println("\n=== Step 5: Print ride history after first cycle ===");
        carousel.printRideHistory();
        
        System.out.println("\n=== Step 6: Run second cycle ===");
        carousel.runOneCycle();
        
        System.out.println("\n=== Step 7: Print waiting queue after second cycle ===");
        carousel.printQueue();
        
        System.out.println("\n=== Step 8: Print ride history after second cycle ===");
        carousel.printRideHistory();
        
        System.out.println("\n=== Step 9: Run third cycle ===");
        carousel.runOneCycle();
        
        System.out.println("\n=== Step 10: Print final status ===");
        System.out.println("Total cycles run: " + carousel.getNumOfCycles());
        System.out.println("Remaining waiting: " + carousel.getWaitingLine().size() + " people");
        System.out.println("History records: " + carousel.getRideHistory().size() + " people");
        
        // Test edge cases
        System.out.println("\n=== Testing edge cases ===");
        
        // Test 1: Ride without operator
        System.out.println("Test 1: Ride without operator");
        Ride noOperatorRide = new Ride("Unassigned Ride", 2, null);
        noOperatorRide.addVisitorToQueue(new Visitor("Test Visitor", 25, "TEST", "T999", "Standard"));
        noOperatorRide.runOneCycle();
        
        // Test 2: Ride with empty queue
        System.out.println("\nTest 2: Ride with empty queue");
        Ride emptyQueueRide = new Ride("Empty Queue Ride", 2, operator);
        emptyQueueRide.runOneCycle();
        
        System.out.println("\n=== Part 5 test completed ===");
    }
    
    // Reserved methods for future parts
    public void partThree() {}
    public void partFourA() {}
    public void partFourB() {}
    public void partSix() {}
    public void partSeven() {}
}