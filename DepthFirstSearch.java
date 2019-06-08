//COMPLEXITY IS O(|E|+|V|)
public class DepthFirstSearch {
    private MatrixGraph graph;
    private int[]discoveryOrder;
    private int discoveryIndex;
    private int[]finishOrder;
    private int finishIndex;
    private int[] parent;
    private boolean[] visited;

    public DepthFirstSearch(MatrixGraph graph){
        this.graph=graph;
        int n=graph.getNumOfVertex();
        parent=new int[n];
        visited=new boolean[n];
        discoveryOrder=new int[n];
        finishOrder=new int[n];
        discoveryIndex=0;
        finishIndex=0;
        for(int i=0;i<n;++i){
            parent[i]=-1;
        }
        for(int i=0;i<n;++i){
            if(!visited[i])
                depthFirstSearch(i);
        }
        System.out.print("Topological order(reverse finish order):");
        for(int i=finishIndex-1;i>=0;i--){
            System.out.print(finishOrder[i]+" ");
        }
        System.out.println();
        System.out.print("visit order:");
        for(int i=0;i<discoveryIndex;i++){
            System.out.print(discoveryOrder[i]+" ");
        }
    }

    public void depthFirstSearch(int current){
        visited[current]=true;
        discoveryOrder[discoveryIndex++]=current;
        for(int j=0;j<graph.getNumOfVertex();++j){
            if(graph.matrix[current][j]!=0)
                if(!visited[j]){
                    parent[j]=current;
                    depthFirstSearch(j);
                }
        }
        finishOrder[finishIndex++]=current;
    }

    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(7, false);
        graph.insert(0, 1);
        graph.insert(0, 2);
        graph.insert(0, 4);
        graph.insert(0, 3);
        graph.insert(1, 4);
        graph.insert(1, 3);
        graph.insert(2, 0);
        graph.insert(2, 5);
        graph.insert(2, 6);
        graph.insert(3, 4);
        graph.insert(5, 6);
        DepthFirstSearch deneme=new DepthFirstSearch(graph);
    }
}
