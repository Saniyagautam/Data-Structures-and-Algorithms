//Create Balanced BST from a BST
import java.util.ArrayList;


public class bst5 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    public static void getInorder(Node root, ArrayList<Integer>inorder){
        if(root==null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    public static Node balancedBST(ArrayList<Integer>inorder,int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        Node root=new Node(inorder.get(mid));
        root.left=balancedBST(inorder,start,mid-1);
        root.right=balancedBST(inorder,mid+1,end);
        return root;
    }
    public static Node balancedBST(Node root){
        ArrayList<Integer>inorder=new ArrayList<>();
        //get inoreder/sorted arraylist
        getInorder(root, inorder);
        //convert bst to balanced bst
        root=balancedBST(inorder,0,inorder.size()-1);
        return root;
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        /*GIVEN TREE
               8
              / \
             6   10
            /      \
           5        11
          /          \
         3            12
        */
        Node root=new Node(8);
        root.left=new Node(6);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);
        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);
        root=balancedBST(root);
        preOrder(root);
        /*
               8
              / \
             5   11
            / \  / \
           3   6 10 12
         */
    }

}
