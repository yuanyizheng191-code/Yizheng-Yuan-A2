/**
 * Class representing a visitor in the theme park system.
 * Extends the Person class with visitor-specific properties.
 */
public class Visitor extends Person {
    private String ticketNumber;
    private String membershipLevel;

    /**
     * Default constructor initializes visitor with default values.
     * Sets ticket number to "Unknown" and membership level to "Standard".
     */
    public Visitor() {
        super();
        this.ticketNumber = "Unknown";
        this.membershipLevel = "Standard";
    }

    /**
     * Parameterized constructor to create a visitor with specific details.
     * 
     * @param name The visitor's name
     * @param age The visitor's age
     * @param id The visitor's identifier
     * @param ticketNumber The visitor's ticket number
     * @param membershipLevel The visitor's membership level
     */
    public Visitor(String name, int age, String id, String ticketNumber, String membershipLevel) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.membershipLevel = membershipLevel;
    }

    /**
     * Getter and Setter methods
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    /**
     * Returns a string representation of the visitor.
     * 
     * @return A formatted string including parent class details plus ticket and membership information
     */
    @Override
    public String toString() {
        return super.toString() + ", Ticket: " + ticketNumber + ", Membership: " + membershipLevel;
    }
}