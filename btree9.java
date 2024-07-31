// Nodes at Kth Level using levelorder traversal  and Recursive approach
import java.util.*;

public class btree9 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    //lth level using levelorder traversal-->ITERATIVE APPROACH
    public static void levelOrder(Node root,int k,int level){
        if(root==null){
            return;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        

        while(!q.isEmpty()){
            Node currNode=q.remove();
            //element is null
            if(currNode==null){
                //gives next line compulsory
                System.out.println();
                
                if(q.isEmpty()){
                    break;
                }
                else{
                    //add null again 
                    q.add(null);
                    level++;
                }

            }
            //other element than null
            else{ 
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            if(level==k && currNode!=null){
                System.out.print(currNode.data+" ");
            }
        }
    }
    //Kth level using Recursive approach
    public static void kthLevel(Node root,int k, int level){
        if(root==null){
            return ;
        }
        if(level==k){
            System.out.print(root.data+" ");
        }
        kthLevel(root.left, k, level+1);
        kthLevel(root.right, k, level+1);
    }

    public static void main(String[] args) {
    /*      1
          / \
         2   3
        /\   /\
       4  5  6 7
                 */
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        int k=3;
        // levelOrder(root, 3, 1);
        kthLevel(root, k, 1);
}
}

