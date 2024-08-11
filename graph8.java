//Topological Sort for directed acyclic graph ONLY  O(V+E)
import java.util.*;
public class graph8 {
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
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));


        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));


    }
    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer>s=new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph,vis,s,i);
            }
        }
    //printing stack(LIFO ORDER)
    while(!s.isEmpty()){
        System.out.print(s.pop()+" ");
    }
    }
    public static void topSortUtil(ArrayList<Edge>[] graph,boolean vis[],Stack<Integer>s,int curr){

        vis[curr]=true;
        
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph, vis, s, e.dest);
            }
        }
    s.push(curr);
    }

    public static void main(String args[]){
        int V=6;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
