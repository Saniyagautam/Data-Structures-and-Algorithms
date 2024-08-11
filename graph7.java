//Finding cycle in directed graph O(V+E)
import java.util.*;
public class graph7 {
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
        // graph[0].add(new Edge(0,2));

        // graph[1].add(new Edge(1,0));

        // graph[2].add(new Edge(2,3));

        // graph[3].add(new Edge(3,0));

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,3));
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        boolean stk[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,stk,i)){
                    return true;
                }
            }
        }
    return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean vis[],boolean stk[],int curr){

        vis[curr]=true;
        stk[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stk[e.dest]){//if neighbr in stack (cycle exists)
                return true;
            }
            if(!vis[e.dest] && detectCycleUtil(graph, vis, stk, e.dest)){//if not vis and fn returns true
                return true;
            }
        }
    stk[curr]=false;//else make curr false in stack
    return false;
    }

    public static void main(String args[]){
        int V=4;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
