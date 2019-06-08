import java.util.*;

//COMPLEXITY IS O(|V|^2)
public class primsAlgorithm {
    public static ArrayList<Edge> prim(MatrixGraph graph,int start) {
        ArrayList<Edge> result=new ArrayList<>();
        int numV=graph.getNumOfVertex();
        Set<Integer>vMinusS=new HashSet<>(numV);
        Queue<Edge> pq=new PriorityQueue<>(numV,new CompareEdge());
        for(int i=0;i<numV;++i){
            if(i!=start){
                vMinusS.add(i);
            }
        }
        int current=start;
        while (!vMinusS.isEmpty()){
            for(int destination=1;destination<graph.getNumOfVertex();++destination){
                if(graph.matrix[current][destination]!=0&&vMinusS.contains((destination))){
                    pq.add(new Edge(current, destination,graph.matrix[current][destination]));
                }
            }
            int dest=-1;
            Edge edge=null;
            do{
                edge=pq.remove();
                dest=edge.getDestination();
            }while (!vMinusS.contains(dest));
            vMinusS.remove(dest);
            result.add(edge);
            current=dest;
        }
        return result;

    }

    public static void main(String[] args) {
        MatrixGraph graph=new MatrixGraph(6, false);
        graph.insert(0, 2,1);
        graph.insert(1, 2,5);
        graph.insert(4, 2,6);
        graph.insert(5, 2,4);
        graph.insert(3, 2,5);
        graph.insert(0, 1,6);
        graph.insert(1, 4,3);
        graph.insert(4, 5,5);
        graph.insert(5, 3,2);
        graph.insert(3, 0,5);
        /*graph.insert(7, 6, 1);
        graph.insert(2, 8, 2);
        graph.insert(6, 5, 2);
        graph.insert(0, 1, 4);
        graph.insert(2, 5, 4);
        graph.insert(8, 6, 6);
        graph.insert(7, 8, 7);
        graph.insert(2, 3, 7);
        graph.insert(0, 7, 8);
        graph.insert(1, 2, 8);
        graph.insert(3, 4, 9);
        graph.insert(5, 4, 10);
        graph.insert(3, 5, 14);*/

        //ArrayList<Edge>edgelists=prim(graph, 0);
        //System.out.println(edgelists);
        graph.print();












    }

}
