import java.util.Arrays;
import java.util.HashSet;

/*WEIGHTED SHORTEST PATH*/
//COMPLEXITY IS O(|V|^2)
public class djikstrasAlgorithm {
    public static void djalgorithm(MatrixGraph graph,int start,int[]pred,double[]dist) {
        int numV=graph.getNumOfVertex();
        HashSet<Integer> vMinusS=new HashSet<>(numV);
        for(int i=0;i<numV;++i){
            if(i!=start)
                vMinusS.add(i);
        }
        for(int v: vMinusS){
            pred[v]=start;
            dist[v]=graph.matrix[start][v];
            if(dist[v]==0)
                dist[v]=Double.POSITIVE_INFINITY;
            //System.out.println(dist[v]);
        }
        while(vMinusS.size()!=0){
            double minDist=Double.POSITIVE_INFINITY;
            int u=-1;
            for(int v:vMinusS){
                if(dist[v]<minDist){
                    minDist=dist[v];
                    u=v;//v-s'de en düşük distance'lı olanı seçme
                }
            }
            vMinusS.remove(u);
            for (int v: vMinusS){
                if(graph.isEdge(u, v)){
                    double weight=graph.matrix[u][v];
                    if(dist[u]+weight<dist[v]){
                        dist[v]=dist[u]+weight;
                        pred[v]=u;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MatrixGraph deneme=new MatrixGraph(5, true);
        deneme.insert(0, 1, 10);
        deneme.insert(0, 3,30);
        deneme.insert(0, 4,100);
        deneme.insert(1, 2,50);
        deneme.insert(3, 2,20);
        deneme.insert(2, 4,10);
        deneme.insert(3, 4,60);
        int[]pred=new int[5];
        double[]dist=new double[5];
        djalgorithm(deneme,0,pred,dist);
        for(int i=0;i<pred.length;++i){
            System.out.print(pred[i]+" ");
        }
        System.out.println();
        for(int i=0;i<dist.length;++i){
            System.out.print(dist[i]+ " ");
        }

    }
}
