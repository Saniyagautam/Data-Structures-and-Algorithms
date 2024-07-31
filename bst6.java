//Calculate the length (interms of nodes) largest BST in a BT(binary tree)
public class bst6 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    //creating class Info
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    //creating a var maxSize which trace max size of bst
    public static int maxSize=0;//initially 0

    //function to find
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);

        int size=(leftInfo.size+rightInfo.size+1);
        int min=Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        //check is bst or not
        if(leftInfo.max>=root.data || rightInfo.min<=root.data){
            return new Info(false,size,min,max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxSize=Math.max(maxSize,size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }
    public static void main(String[] args) {
        /*GIVEN TREE
               50
              / \
             30   60
            / \    / \
           5   20 45 70
                    / \
                  65   80
        */
        Node root=new Node(50);
        root.left=new Node(30);
        root.left.left=new Node(5);
        root.left.right=new Node(20);

        root.right=new Node(60);
        root.right.left=new Node(45);
        root.right.right=new Node(70);
        root.right.right.left=new Node(65);
        root.right.right.right=new Node(80);

        Info info=largestBST(root);
        System.out.println("Largest size of BST in BT : "+maxSize);
        /*     60
               / \
              45 70
                / \
              65   80 */
    }
}
