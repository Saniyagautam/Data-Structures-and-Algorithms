//calculate Lowest Common Ancestor and then find Minimum distance between 2 nodes
public class btree10{
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
    public static Node lca(Node root,int n1,int n2){
        if(root==null ||root.data==n1 || root.data==n2){
            return root;
        }
        Node leftlca=lca(root.left,n1,n2);
        Node rightlca=lca(root.right,n1,n2);
        if(rightlca==null){
            return leftlca;
        }
        if(leftlca==null){
            return rightlca;
        }
        return root;
    }
    public static int lcaDist(Node root,int n){
        //base case
        if(root==null){
            return -1;
        }
        //root and n overlap(same)
        if(root.data==n){
            return 0;
        }
        int leftDist=lcaDist(root.left, n);
        int rightDist=lcaDist(root.right,n);
        
        if(leftDist==-1){//node in right subtree
            return rightDist+1;
        }
        else{//node in left subtree
            return leftDist+1;
        }


    }
    public static int minDist(Node root,int n1,int n2){
        Node lca=lca(root,n1,n2);
        int dist1=lcaDist(lca,n1);
        int dist2=lcaDist(lca,n2);
        return dist1+dist2;
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
        int n1=4;
        int n2=6;
        System.out.println("Minimum distance between nodes are: "+minDist(root, n1, n2));
    }
    
}