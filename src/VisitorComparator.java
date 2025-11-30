import java.util.Comparator;

/**
 * Comparator for Visitor objects that sorts primarily by name (case-insensitive)
 * and secondarily by age in ascending order.
 */
public class VisitorComparator implements Comparator<Visitor> {
    
    /**
     * Compares two Visitor objects based on name and age.
     * First sorts by name in ascending order (case-insensitive)
     * If names are equal, sorts by age in ascending order
     * 
     * @param v1 the first Visitor to compare
     * @param v2 the second Visitor to compare
     * @return a negative integer, zero, or a positive integer as the first argument
     *         is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Primary sorting criterion: by name in ascending order (case-insensitive)
        int nameComparison = v1.getName().compareToIgnoreCase(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        
        // Secondary sorting criterion: by age in ascending order (if names are equal)
        return Integer.compare(v1.getAge(), v2.getAge());
    }
    
    /**
     * Returns a string representation of this comparator
     * 
     * @return description of the comparator's sorting logic
     */
    @Override
    public String toString() {
        return "VisitorComparator [sorts by name ascending, then by age ascending]";
    }
}