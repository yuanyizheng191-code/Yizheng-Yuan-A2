public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("=== Part 1: Basic Class Testing ===");
        
        // Testing Person class (abstract class cannot be instantiated)
        System.out.println("Person class is abstract and cannot be directly instantiated");
        
        // Testing Employee class
        Employee employee = new Employee("John Smith", 30, "EMP001", "OP001", "Ride Operations");
        System.out.println("Created Employee: " + employee);
        
        // Testing Visitor class
        Visitor visitor = new Visitor("Alice Johnson", 25, "VIS001", "T001", "Gold");
        System.out.println("Created Visitor: " + visitor);
        
        // Testing Ride class
        Ride rollerCoaster = new Ride("Roller Coaster", 20, employee);
        System.out.println("Created Ride: " + rollerCoaster);
        
        // Testing getter and setter methods
        System.out.println("\n=== Getter and Setter Testing ===");
        visitor.setMembershipLevel("Platinum");
        System.out.println("After updating membership level: " + visitor.getMembershipLevel());
        
        rollerCoaster.setCapacity(25);
        System.out.println("After updating capacity: " + rollerCoaster.getCapacity());
    }
    
    // Methods reserved for future parts
    public void partThree() {}
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}