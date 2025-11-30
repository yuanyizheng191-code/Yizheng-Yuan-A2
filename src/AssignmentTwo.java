public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        
        System.out.println("=== Theme Park Visitor Management System ===");
        System.out.println("Running Part 3: Waiting Queue Test\n");
        
        assignment.partThree();
    }
    
    public void partThree() {
        System.out.println("=== Part 3: Waiting Queue Test ===");
        
        // Create operator
        Employee operator = new Employee("John Operator", 30, "EMP001", "OP001", "Ride Operations");
        System.out.println("Created operator: " + operator.getName() + "\n");
        
        // Create ride
        Ride rollerCoaster = new Ride("Super Roller Coaster", 2, operator);
        System.out.println("Created ride: " + rollerCoaster.getRideName() + "\n");
        
        // Create 5 visitors
        Visitor visitor1 = new Visitor("Zhang San", 25, "V001", "T001", "Gold");
        Visitor visitor2 = new Visitor("Li Si", 30, "V002", "T002", "Silver");
        Visitor visitor3 = new Visitor("Wang Wu", 22, "V003", "T003", "Standard");
        Visitor visitor4 = new Visitor("Zhao Liu", 28, "V004", "T004", "Gold");
        Visitor visitor5 = new Visitor("Qian Qi", 35, "V005", "T005", "Standard");
        
        System.out.println("=== Step 1: Add 5 visitors to queue ===");
        // Add visitors to queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        
        System.out.println("\n=== Step 2: Print current queue ===");
        // Print queue
        rollerCoaster.printQueue();
        
        System.out.println("\n=== Step 3: Remove one visitor from queue ===");
        // Remove one visitor
        rollerCoaster.removeVisitorFromQueue();
        
        System.out.println("\n=== Step 4: Print queue after removal ===");
        // Print queue again
        rollerCoaster.printQueue();
        
        System.out.println("\n=== Step 5: Test edge cases ===");
        // Test removing from empty queue
        Ride emptyRide = new Ride("Empty Carousel", 4, operator);
        emptyRide.removeVisitorFromQueue();
        
        // Test adding null visitor
        emptyRide.addVisitorToQueue(null);
        
        System.out.println("\n=== Part 3 Test Completed ===");
    }
    
    // Reserved methods for subsequent parts
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}