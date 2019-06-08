import java.util.Iterator;

public class MatrixGraph {
    protected double[][]matrix;
    private int numOfVertex;
    private boolean directed;

    private class edgeIterator implements Iterator<Edge>{
        int index;
        int node;

        public edgeIterator(int node){
            this.node=node;
            index=0;
        }
        @Override
        public boolean hasNext() {
            return index+1<numOfVertex;
        }

        @Override
        public Edge next() {
            Edge willReturn=null;
            if (hasNext()) {
                willReturn=new Edge(node, index,matrix[node][index]);
                ++index;
            }
            return willReturn;

        }
    }

    /**
     * Standart graph constructor.
     * @param numOfVertex total number of vertex.
     * @param directed explains Is graph directed or undirected.
     */
    public MatrixGraph(int numOfVertex, boolean directed) {
        this.numOfVertex = numOfVertex;
        this.directed = directed;
        matrix=new double[numOfVertex][numOfVertex];//expected zero index
    }

    /**
     * Returns total number of vertex in graph.
     * @return integer value of vertex.
     */
    public int getNumOfVertex() {
        return numOfVertex;
    }

    /**
     * Returns is directed?
     * @return boolean value of directed.
     */
    public boolean isDirected() {
        return directed;
    }

    /**
     * Inserts a new edge in a graph.
     * @param source pointer vertex.
     * @param dest pointed vertex.
     */
    public void insert(int source,int dest){
        matrix[source][dest]=1.0;
        if(!isDirected()){
            matrix[dest][source]=1.0;
        }

    }

    public void insert(int source,int dest,double weight){
        matrix[source][dest]=weight;
        if(!isDirected()){
            matrix[dest][source]=weight;
        }
    }

    /**
     * Controls the source and destination pair's availability.
     * @param source pointer vertex.
     * @param dest pointed vertex.
     * @return boolean edge value.
     */
    boolean isEdge(int source,int dest){
        return matrix[source][dest]!=0.0;
    }

    Edge getEdge(int source,int dest){
        if(isEdge(source, dest)){
            return new Edge(source, dest,matrix[source][dest]);
        }
        return new Edge(source, dest,Double.POSITIVE_INFINITY);
    }

    /**
     * Adds transitive edges to graph according to added edges.
     */
    public void addTransitiveEdges(){
        boolean flag=false;
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[i].length;++j){
                if(matrix[i][j]==1.0){
                    for(int k=0;k<matrix[j].length;++k){
                        if (matrix[j][k]==1.0){//dikkat
                            matrix[i][k]=1.0;
                            if(i==matrix.length-1&&!flag){
                                i=k;
                                flag=true;
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * returns String that express the graph matrixes.
     * @return Matrix's String type expression.
     */
    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix.length;++j){
                builder.append((int)matrix[i][j]);
                builder.append(" ");

            }
            builder.append("\n");
        }

        return builder.toString();
    }

    /**
     * Finds the number of popular people.
     * @return Number of popular people.
     */
    public int numOfPopular(){
        int popularPeople=0;
        for(int i=0;i<matrix.length;++i){
            boolean isPopular=true;
            for(int j=0;j<matrix.length;++j){
                if(i!=j&&matrix[j][i]!=1.0)
                    isPopular=false;
            }
            if(isPopular)
                ++popularPeople;

        }

        return popularPeople;
    }

    public void print(){
        Iterator deneme=new edgeIterator(0);
        while(deneme.hasNext()){
            System.out.println(deneme.next());
        }
    }


}
