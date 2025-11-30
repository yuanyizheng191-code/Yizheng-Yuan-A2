public class Visitor extends Person {
    private String ticketNumber;
    private String membershipLevel;

    // Default constructor
    public Visitor() {
        super();
        this.ticketNumber = "Unknown";
        this.membershipLevel = "Standard";
    }

    // Parameterized constructor
    public Visitor(String name, int age, String id, String ticketNumber, String membershipLevel) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.membershipLevel = membershipLevel;
    }

    // Getter and Setter methods
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

    @Override
    public String toString() {
        return super.toString() + ", Ticket: " + ticketNumber + ", Membership: " + membershipLevel;
    }
}