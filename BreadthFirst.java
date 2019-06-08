import java.util.*;
//COMPLEXITY IS O(|E|)
public class BreadthFirst {

    public static int[] BreadthFirstSearch(MatrixGraph graph,int start){
        Queue<Integer> theQueue=new LinkedList<>();
        List<Integer> visitSeq=new ArrayList<>();
        int[]parent=new int[graph.getNumOfVertex()];
        for(int i = 0;i<parent.length;++i){
            parent[i]=-1;
        }
        boolean[]identified=new boolean[graph.getNumOfVertex()];
        theQueue.add(start);
        identified[start]=true;
        while (!theQueue.isEmpty()){
            int poll=theQueue.poll();
            visitSeq.add(poll);
            for(int j=0;j<graph.getNumOfVertex();j++){
                if(graph.matrix[poll][j]!=0&&!identified[j]){
                    identified[j]=true;
                    parent[j]=poll;
                    theQueue.add(j);

                }
            }
        }
        //System.out.println(visitSeq);
        return parent;
    }



    public static void main(String[] args) {
        BreadthFirst deneme=new BreadthFirst();
        MatrixGraph graph = new MatrixGraph(13, false);
        graph.insert(0, 1);
        graph.insert(1, 4);
        graph.insert(1, 2);
        graph.insert(2, 8);
        graph.insert(2, 7);
        graph.insert(7, 9);
        graph.insert(8, 12);
        graph.insert(8, 11);
        graph.insert(7, 6);
        graph.insert(6, 5);
        graph.insert(5, 3);
        graph.insert(5, 4);
        graph.insert(5, 10);
        graph.insert(4, 10);
        graph.insert(11, 10);
        int[] array=BreadthFirstSearch(graph, 0);

        Deque<Integer> thePath = new ArrayDeque<>();
        int v = graph.getNumOfVertex() -1;//13-1 yani 12 değerlikli vertice'e gidecek yolu buluyor parent arrayinden
        while (array[v] != -1) {
            thePath.push(v);
            v = array[v];
        }
        System.out.println("The Shortest path is:");
        while (!thePath.isEmpty()) {
            System.out.print(thePath.pop()+" ");
        }
        System.out.println("\nParent array:");
        for(int i=0;i<array.length;++i){
            System.out.print(array[i]+" ");
        }

    }


}
