import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 第一排序条件：按姓名升序
        int nameComparison = v1.getName().compareToIgnoreCase(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        
        // 第二排序条件：按年龄升序（如果姓名相同）
        return Integer.compare(v1.getAge(), v2.getAge());
    }
    
    @Override
    public String toString() {
        return "VisitorComparator [按姓名升序，姓名相同时按年龄升序]";
    }
}