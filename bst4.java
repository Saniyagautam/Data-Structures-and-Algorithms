//Create balanced BST from the Sorted arr (Inorder traversal) O(n)
public class bst4 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    public static Node createBST(int arr[],int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr, start, mid-1);
        root.right=createBST(arr, mid+1, end);
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
        int arr[]={3,5,6,8,10,11,12};
        Node root=createBST(arr, 0, arr.length-1);
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
