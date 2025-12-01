/**
 * Interface defining the core operations for a ride in the theme park system.
 * This interface specifies methods for queue management, ride history tracking, and ride cycle operation.
 */
public interface RideInterface {
    /**
     * Part 3: Queue operation methods
     */
    
    /**
     * Adds a visitor to the ride's waiting queue.
     * 
     * @param visitor The visitor to add to the queue
     */
    void addVisitorToQueue(Visitor visitor);
    
    /**
     * Removes the next visitor from the ride's waiting queue.
     */
    void removeVisitorFromQueue();
    
    /**
     * Prints all visitors currently in the ride's waiting queue.
     */
    void printQueue();
    
    /**
     * Part 4: History operation methods
     */
    
    /**
     * Adds a visitor to the ride's history records.
     * 
     * @param visitor The visitor to add to ride history
     */
    void addVisitorToHistory(Visitor visitor);
    
    /**
     * Checks if a visitor has previously ridden the attraction.
     * 
     * @param visitor The visitor to check in ride history
     * @return true if the visitor is found in history, false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);
    
    /**
     * Gets the total number of visitors who have ridden the attraction.
     * 
     * @return The count of visitors in ride history
     */
    int numberOfVisitors();
    
    /**
     * Prints all visitors in the ride's history records.
     */
    void printRideHistory();
    
    /**
     * Part 5: Run ride cycle
     */
    
    /**
     * Executes one complete cycle of the ride operation.
     * This typically involves loading visitors from queue, running the ride,
     * and updating history records.
     */
    void runOneCycle();
}