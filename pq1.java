//priority queues using JCF

import java.util.Comparator;
import java.util.PriorityQueue;

public class pq1 {
    public static void main(String[] args) {
        //reverOrder means largest num have highest priority
        PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(2);
        pq.add(5);//O(logn)
        pq.add(1);
        while(!pq.isEmpty()){
            pq.peek();//O(1)
            System.out.println(pq.remove());
        }
    }
}
