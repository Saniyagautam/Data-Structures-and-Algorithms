//creation of graph
import java.util.*;
public class graph1{
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    public static void main(String[] args) {
        /*             (5)  (1)  (2)
                    0-----1----2----4
                          |    |
                       (3)|    |(1)
                          |----3   

                    */
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];

        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();//from null to empty AL
        }
        //0th index
        graph[0].add(new Edge(0,1,5));
        //1st index
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        graph[1].add(new Edge(1,0,5));
        //2nd index
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));
        //3rd index
        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,3,1));
        //4th index
        graph[4].add(new Edge(4,2,2));
        
        //NEIGHBOURS OF 2
        for(int i=0;i<graph[2].size();i++){
            Edge e=graph[2].get(i);
            System.out.println(e.dest);
        }

    }
}