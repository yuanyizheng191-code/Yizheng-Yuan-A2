public interface RideInterface {
    // Part 3: Queue operation methods
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();
    
    // Part 4: History operation methods
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
    
    // Part 5: Run ride cycle
    void runOneCycle();
}