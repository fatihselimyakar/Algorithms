import java.util.Comparator;

public class CompareEdge implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
