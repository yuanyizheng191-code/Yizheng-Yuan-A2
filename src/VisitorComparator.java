import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First sorting criteria: by name in ascending order
        int nameComparison = v1.getName().compareToIgnoreCase(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        
        // Second sorting criteria: by age in ascending order (if names are the same)
        return Integer.compare(v1.getAge(), v2.getAge());
    }
    
    @Override
    public String toString() {
        return "VisitorComparator [sorted by name ascending, then by age ascending if names are equal]";
    }
}