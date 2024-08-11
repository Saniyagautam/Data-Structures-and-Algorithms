//Bipartite graph O(V+E)
import java.util.*;
public class graph6 {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge (2,0));
        graph[2].add(new Edge (2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
        
        // graph[4].add(new Edge(4,3));
        // graph[4].add(new Edge(4,2));
    }
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[]=new int[graph.length];
        //Initilise with -1 
        for(int i=0;i<graph.length;i++){
            col[i]=-1;//No color
        }
        Queue<Integer>q=new LinkedList<>();
        
        //for all components
        for(int i=0;i<graph.length;i++){
            //first node
            if(col[i]==-1){
                q.add(i);
                col[i]=0;//color first node 
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e=graph[curr].get(j);//getting neighbour
                        if(col[e.dest]==-1){
                            int nextcolor=col[curr]==0?1:0;//give opposite color to neighbour
                            col[e.dest]=nextcolor;
                            q.add(e.dest);
                        }
                        else if(col[e.dest]==col[curr]){//if neighbour and curr have same color then not bipartite
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
   
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
        
        
    }

}
