public class Edge {
    private int source;
    private int destination;
    private double weight;

    public Edge(int source,int destination,double weight){
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }

    public Edge(int source,int destination){
        this(source,destination,1);
    }

    public double getWeight() {
        return weight;
    }

    public int getDestination() {
        return destination;
    }

    public int getSource() {
        return source;
    }

    public int hashCode(){
        return (source+""+destination).hashCode();
    }

    //NOT:OBJELERİN OBJECT.HASHCODE'U VAR FAKAT PRIMITIVELER ICIN Double.hashcode(1.0) veya Integer.hashcode(1) gibi şeyler kullanmak lazım
    @Override
    public boolean equals(Object o){//OVERRIDE EDILMIS EQUALS OBJECTTEN EDILDIGI ICIN CAST EDILMEDEN CAGRILSA BILE AYNI ISI YAPAR HER TURLU CALISIR
        if (o instanceof Edge){
            return o.hashCode()==this.hashCode();
        }
        return false;

    }
    /*public boolean equals(Edge o){ //OVERLOAD EDİLMİŞ EQUALS CAST EDILMEDIGI TAKTIRDE DEGISMEMIS(OBJECTIN) EQUALS'I KULLANIR VE HATALI CALISIR
        return o.hashCode()==this.hashCode();
    }*/

    @Override
    public String toString() {
        return source+" "+destination+" "+weight;
    }
}
