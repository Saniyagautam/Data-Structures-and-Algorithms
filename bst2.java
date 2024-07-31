//Ques 1-->Print in range (include both lower limit and upper limit)
//Ques 2-->print all root to leaf paths 
//Ques 3 -->Check if Valid BST or not(IMPORTANT)
import java.util.*;
public class bst2 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);//creating node (root)
            return root;
        }
        if(root.data>val){
            //left subtree
            root.left=insert(root.left,val);
        }
        else{
            root.right=insert(root.right,val);
        }
    return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //Ques 1 
    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return ;
        }
        if(root.data>=k1 && root.data<=k2){//lies in both left and right subtree
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){//lies in left subtree only
            printInRange(root.left, k1, k2);
        }
        else{//lies in right subtree only 
            printInRange(root.right, k1, k2);
        }
    }
    
    //Ques 2 
    public static void printPath(ArrayList<Integer>path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.print("Null");
        System.out.println();
    }
    public static void printRoot2leaf(Node root,ArrayList<Integer>path){
        if(root==null){
            return ;
        }
        path.add(root.data);//add itself 
        if(root.left== null && root.right==null){
            printPath(path);//if leaf node print path
        }
        printRoot2leaf(root.left, path);//trace left
        printRoot2leaf(root.right, path);//trace right
        path.remove(path.size()-1);//BACKTRACKING 
    }

    //Ques 3
    public static boolean isValidBST(Node root,Node min, Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        int values[]={8,5,3,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        // printInRange(root, 7, 14);
        // printRoot2leaf(root, new ArrayList<>());
        if(isValidBST(root, null, null)){
            System.out.println("Valid!!!");
        }
        else{
            System.out.println("InValid");
        }
    }
}
