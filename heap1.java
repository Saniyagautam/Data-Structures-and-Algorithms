//basic functions implementation of heaps
import java.util.*;
public class heap1{
    static class Heap{
        ArrayList<Integer>arr=new ArrayList<>();
        public void add(int data){
            //add at last in arr
            arr.add(data);

            int x=arr.size()-1;//idx of newly added data
            int par=(x-1)/2;//idx of it's parent
            //fix heap
            while(arr.get(x)<arr.get(par)){
                //swap
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x=par;
                par=(x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        //private as can only call by method inside the heap class
        private void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;

            while(left<arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx=left;
            }
            while(right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx=right;
            }
            if(minIdx!=i){
                //swap minidx with root
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                //call for lower levels
                heapify(minIdx);
            }
        }
        public int remove(){
            int data=arr.get(0);
            //step 1 swap with last el

            int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2 delete last
            arr.remove(arr.size()-1);

            //step 3 heapify from root
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(7);
        h.add(2);
        h.add(9);
        h.add(1);
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
    /*
    CONCLUSIONS IT CAN BE IMPLEMENTED BY PQ JCF 
    DIRECTLY USE INBUILT FUNCTIONS BUT UNDERSTAND IT ALSO
     */
}