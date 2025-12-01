import java.util.*;
import java.io.*;

/**
 * Represents a ride in the theme park system.
 * This class implements the RideInterface and provides functionality for managing
 * visitor queues, ride history, ride operations, and data import/export.
 */
public class Ride implements RideInterface {
    private String rideName;
    private int maxRider;
    private Employee operator;
    private int numOfCycles;
    
    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;

    /**
     * Default constructor creates a ride with default values.
     * Sets name to "Unknown Ride", max riders to 2, and initializes empty queues.
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
     * Parameterized constructor creates a ride with specified values.
     * 
     * @param rideName The name of the ride
     * @param maxRider The maximum number of riders per cycle
     * @param operator The employee operating the ride
     */
    public Ride(String rideName, int maxRider, Employee operator) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.operator = operator;
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    /**
     * Getter and Setter methods
     */
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
     * @return A formatted string with ride details including name, capacity, operator, cycles, and queue statistics
     */
    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getName() : "No operator assigned";
        return "Ride: " + rideName + ", MaxRider: " + maxRider + ", Operator: " + operatorInfo + 
               ", Cycles: " + numOfCycles + ", Waiting: " + waitingLine.size() + " visitors, History: " + rideHistory.size() + " visitors";
    }

    /**
     * Part 3: Queue operation methods
     */
    
    /**
     * Adds a visitor to the ride's waiting queue.
     * 
     * @param visitor The visitor to add to the queue
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.add(visitor);
            System.out.println("✓ " + visitor.getName() + " has been added to " + rideName + " waiting queue");
        } else {
            System.out.println("✗ Cannot add null visitor to queue");
        }
    }

    /**
     * Removes the next visitor from the ride's waiting queue.
     */
    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removed = waitingLine.poll();
            System.out.println("✓ " + removed.getName() + " has been removed from " + rideName + " waiting queue");
        } else {
            System.out.println("✗ " + rideName + " waiting queue is empty, cannot remove visitor");
        }
    }

    /**
     * Prints all visitors currently in the ride's waiting queue.
     */
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

    /**
     * Part 4A: History operation methods
     */
    
    /**
     * Adds a visitor to the ride's history records.
     * 
     * @param visitor The visitor to add to ride history
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
     * Checks if a visitor has previously ridden the attraction.
     * 
     * @param visitor The visitor to check in ride history
     * @return true if the visitor is found in history, false otherwise
     */
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

    /**
     * Gets the total number of visitors who have ridden the attraction.
     * 
     * @return The count of visitors in ride history
     */
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println(rideName + " ride history has " + count + " visitors");
        return count;
    }

    /**
     * Prints all visitors in the ride's history records using an Iterator.
     */
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

    /**
     * Part 4B: Sorting method
     */
    
    /**
     * Sorts the ride history using the provided comparator.
     * 
     * @param comparator The comparator to use for sorting visitors
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " ride history is empty, no need to sort");
            return;
        }
        
        Collections.sort(rideHistory, comparator);
        System.out.println("✓ " + rideName + " ride history has been sorted");
    }

    /**
     * Part 5: Run ride cycle
     */
    
    /**
     * Executes one complete cycle of the ride operation.
     * This method loads as many visitors as possible (up to maxRider) from the waiting queue,
     * runs the ride for these visitors, and adds them to ride history.
     */
    @Override
    public void runOneCycle() {
        System.out.println("\n=== Attempting to run " + rideName + " for one cycle ===");
        
        if (operator == null) {
            System.out.println("✗ Cannot run " + rideName + " - No operator assigned");
            return;
        }
        
        if (waitingLine.isEmpty()) {
            System.out.println("✗ Cannot run " + rideName + " - Waiting queue is empty");
            return;
        }
        
        System.out.println("Operator: " + operator.getName());
        System.out.println("Maximum visitors per cycle: " + maxRider);
        System.out.println("Current waiting: " + waitingLine.size());
        
        int ridersThisCycle = 0;
        List<Visitor> currentRiders = new ArrayList<>();
        
        while (ridersThisCycle < maxRider && !waitingLine.isEmpty()) {
            Visitor rider = waitingLine.poll();
            currentRiders.add(rider);
            ridersThisCycle++;
            System.out.println("  ✓ " + rider.getName() + " is riding " + rideName);
        }
        
        for (Visitor rider : currentRiders) {
            addVisitorToHistory(rider);
        }
        
        numOfCycles++;
        
        System.out.println("Riders this cycle: " + ridersThisCycle);
        System.out.println("Total cycles run: " + numOfCycles);
        System.out.println("Remaining waiting: " + waitingLine.size());
        System.out.println("✓ " + rideName + " cycle completed");
    }

    /**
     * Part 6: Export ride history to file
     */
    
    /**
     * Exports the ride history to a CSV file.
     * Each line in the file contains visitor information in CSV format.
     * 
     * @param filename The name of the file to export to
     */
    public void exportRideHistory(String filename) {
        System.out.println("\n=== Exporting " + rideName + " ride history to file ===");
        
        if (rideHistory.isEmpty()) {
            System.out.println("✗ Ride history is empty, no need to export");
            return;
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            int exportedCount = 0;
            
            for (Visitor visitor : rideHistory) {
                String line = visitor.getName() + "," + 
                             visitor.getAge() + "," + 
                             visitor.getId() + "," + 
                             visitor.getTicketNumber() + "," + 
                             visitor.getMembershipLevel();
                writer.println(line);
                exportedCount++;
            }
            
            System.out.println("✓ Successfully exported " + exportedCount + " visitors to file: " + filename);
            System.out.println("File path: " + new File(filename).getAbsolutePath());
            
        } catch (IOException e) {
            System.out.println("✗ Error occurred during file export: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Unknown error: " + e.getMessage());
        }
    }

    /**
     * Part 7: Import ride history from file
     */
    
    /**
     * Imports ride history from a CSV file.
     * The file should contain visitor information in CSV format, with each line representing one visitor.
     * Handles various error cases including file not found, unreadable file, and invalid data formats.
     * 
     * @param filename The name of the file to import from
     */
    public void importRideHistory(String filename) {
        System.out.println("\n=== Importing ride history to " + rideName + " from file ===");
        
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("✗ File does not exist: " + filename);
            return;
        }
        
        if (!file.canRead()) {
            System.out.println("✗ File cannot be read: " + filename);
            return;
        }
        
        int importedCount = 0;
        int errorCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            
            System.out.println("Starting to read file: " + filename);
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
                if (line.isEmpty()) {
                    lineNumber++;
                    continue;
                }
                
                String[] parts = line.split(",");
                
                if (parts.length == 5) {
                    try {
                        String name = parts[0].trim();
                        int age = Integer.parseInt(parts[1].trim());
                        String id = parts[2].trim();
                        String ticketNumber = parts[3].trim();
                        String membershipLevel = parts[4].trim();
                        
                        Visitor visitor = new Visitor(name, age, id, ticketNumber, membershipLevel);
                        
                        if (rideHistory.add(visitor)) {
                            importedCount++;
                            System.out.println("  ✓ Line " + lineNumber + ": Successfully imported " + name);
                        } else {
                            errorCount++;
                            System.out.println("  ✗ Line " + lineNumber + ": Import failed - " + name);
                        }
                        
                    } catch (NumberFormatException e) {
                        errorCount++;
                        System.out.println("  ✗ Line " + lineNumber + ": Age format error - " + line);
                    } catch (Exception e) {
                        errorCount++;
                        System.out.println("  ✗ Line " + lineNumber + ": Data parsing error - " + e.getMessage());
                    }
                } else {
                    errorCount++;
                    System.out.println("  ✗ Line " + lineNumber + ": Data format error, expected 5 fields, found " + parts.length + " - " + line);
                }
                
                lineNumber++;
            }
            
            System.out.println("\n=== Import Complete ===");
            System.out.println("✓ Successfully imported: " + importedCount + " visitors");
            System.out.println("✗ Failed to import: " + errorCount + " records");
            System.out.println("Current ride history total: " + rideHistory.size() + " visitors");
            
        } catch (FileNotFoundException e) {
            System.out.println("✗ File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("✗ Error occurred while reading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Unknown error: " + e.getMessage());
        }
    }
}