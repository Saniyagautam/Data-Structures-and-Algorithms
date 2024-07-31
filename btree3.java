/*sum of nodes ,
height of tree,
total nodes , 
sum of all left leaves ,
sum of all right leaves in tree*/

public class btree3 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }
    //Count depth/height of tree in terms of nodes
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    //Count nodes
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftcount=countNodes(root.left);
        int rightcount=countNodes(root.right);
        return leftcount+rightcount+1;
    }
    //calculate sum of all nodes
    public static int sumNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=sumNodes(root.left);
        int rightSum=sumNodes(root.right);
        return leftSum+rightSum+root.data;
    }
    //sum of all left leaves 
    public static int sumofLeftLeaves(Node root){
        if(root==null){
            return 0;
        }
        int sum=0;
        if(root.left!=null && root.left.left==null && root.left.right==null){
            sum+=root.left.data;
        }
        sum+=sumofLeftLeaves(root.left);
        sum+=sumofLeftLeaves(root.right);
        return sum;
    }
    //sum of all right leaves 
    public static int sumofRightLeaves(Node root){
        if(root==null){
            return 0;
        }
        int sum=0;
        if(root.right!=null && root.right.left==null && root.right.right==null){
            sum+=root.right.data;
        }
        sum+=sumofRightLeaves(root.left);
        sum+=sumofRightLeaves(root.right);
        return sum;
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
        System.out.println("Height if Tree is : "+height(root));
        System.out.println("Total nodes in trees are :"+countNodes(root));
        System.out.println("Sum of all the Nodes are : "+sumNodes(root));
        System.out.println("Sum of all left leaves in tree : "+sumofLeftLeaves(root));
        System.out.println("Sum of all Right leaves in tree : "+sumofRightLeaves(root));

    }
}
