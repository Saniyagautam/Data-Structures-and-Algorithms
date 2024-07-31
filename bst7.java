//MERGE 2 bst and form single bst
import java.util.*;
public class bst7 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    public static void getInorder(ArrayList<Integer>arr,Node root){
        if(root==null){
            return;
        }
        getInorder(arr, root.left);
        arr.add(root.data);
        getInorder(arr, root.right);
    }

    public static Node createBST(ArrayList<Integer>arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBST(arr, start, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }
    public static Node mergeBSTs(Node root1,Node root2){
        //getting arrays of both trees
        ArrayList<Integer>arr1=new ArrayList<>();
        getInorder(arr1, root1);
        ArrayList<Integer>arr2=new ArrayList<>();
        getInorder(arr2, root2);
        //merged both list to form single sorted list
        ArrayList<Integer>finalArr=new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }
            else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }
        //convert the finalArraylist to the BST 
        return createBST(finalArr, 0, finalArr.size()-1);
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
        /*  2
           / \
          1   4
         */
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);
        /*  2
           / \
          1   4
         */
        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);
        Node root=mergeBSTs(root1, root2);
        preOrder(root);
        /*    3
             / \
            1   9
            \   /\
            2  4  12
         */ 

    }
}
