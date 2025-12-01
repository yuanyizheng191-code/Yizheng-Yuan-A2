/**
 * Abstract base class representing a person in the theme park system.
 * This class provides common properties and methods for all types of people.
 */
public abstract class Person {
    private String name;
    private int age;
    private String id;

    /**
     * Default constructor initializes person with default values.
     * Sets name and ID to "Unknown", and age to 0.
     */
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.id = "Unknown";
    }

    /**
     * Parameterized constructor to create a person with specific details.
     * 
     * @param name The person's name
     * @param age The person's age
     * @param id The person's identifier
     */
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    /**
     * Getter and Setter methods
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns a string representation of the person.
     * 
     * @return A formatted string with name, age, and ID information
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", ID: " + id;
    }
}