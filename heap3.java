//nearest k elements to origin
import java.util.*;
public class heap3 {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distsq;
        int idx;
        public Point(int x,int y,int distsq,int idx){
            this.x=x;
            this.y=y;
            this.distsq=distsq;
            this.idx=idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distsq-p2.distsq;//for asc order 
            //for desc order p2.distsq-this.distsq
        }
    }
    public static void main(String[] args) {
        int arr[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        PriorityQueue<Point>pq=new PriorityQueue<>();
        //insert into pq 
        for(int i=0;i<arr.length;i++){
            int distsq=arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1];
            pq.add(new Point(arr[i][0], arr[i][1],distsq,i));
        }
        //print k nearest
        for(int i=0;i<k;i++){
            System.out.println("C"+pq.remove().idx);
        }

    }
}
