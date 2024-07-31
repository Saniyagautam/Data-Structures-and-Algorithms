//calculate sum of nodes in range (BETTER SOLUTION EXISTS)
import java.util.*;
public class bst8 {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    static int sum=0;
    public static int CalculateSumofRange(Node root,int low,int high){
        if(root==null){
            return 0;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.peek();
            q.remove();
            if(curr.data>=low && curr.data<=high){
                sum+=curr.data;
            }
            if(curr.left!=null && curr.data>=low){
                q.add(curr.left);
            }
            if(curr.right!=null && curr.data<=high){
                q.add(curr.right);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
         /*
               8
              / \
             5   11
            / \    \
           3   6    20
         */
        Node root=new Node(8);
        root.left=new Node(5);
        root.right=new Node(11);
        root.left.left=new Node(3);
        root.left.right=new Node(6);
        root.right.right=new Node(20);
        int low=7 ;
        int high=15;
        System.out.println(CalculateSumofRange(root, low, high));
    }
}
