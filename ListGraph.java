import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListGraph {
    private boolean directed;
    private int numV;
    private List<Edge>[] edges;

    @SuppressWarnings("unchecked")
    public ListGraph(int numV,boolean directed){
        this.numV=numV;
        this.directed=directed;
        edges=new List[numV];
        for(int i=0;i<numV;++i){
            edges[i]=new LinkedList<Edge>();
        }
    }

    public Iterator<Edge> edgeIterator(int source){
        return edges[source].iterator();
    }

    public boolean isEdge(int source,int dest){
        return edges[source].contains(new Edge(source, dest));
    }

    public Edge getEdge(int source,int dest){
        for(Edge edge:edges[source]){
            if(edge.equals(new Edge(source, dest))){
                return edge;
            }
        }
        return null;
    }

    public void insert(Edge edge){
        edges[edge.getSource()].add(edge);
        if(!isDirected()){
            edges[edge.getDestination()].add(new Edge(edge.getDestination(), edge.getSource(),edge.getWeight()));
        }
    }

    public int getNumV() {
        return numV;
    }

    public boolean isDirected() {
        return directed;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<getNumV();++i){
            for (Edge edges:edges[i]){
                builder.append(edges+" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ListGraph deneme=new ListGraph(5, true);
        deneme.insert(new Edge(0,1 ));
        deneme.insert(new Edge(0,3 ));
        deneme.insert(new Edge(1,2 ));
        deneme.insert(new Edge(2,3 ));
        deneme.insert(new Edge(3,4 ));
        deneme.insert(new Edge(4,2 ));
        deneme.insert(new Edge(2,7 ,10));
        System.out.println(deneme.getNumV());
        System.out.println(deneme.isEdge(2, 8));
        System.out.println(deneme.getEdge(2, 7));
        System.out.println(deneme.getEdge(2, 10));



        System.out.println(deneme);
    }
}
