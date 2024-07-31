//Calculate the max sum of bst in bt
public class bst9 {
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
        int sum;
        int min;
        int max;
        public Info(boolean isBST,int sum,int min,int max){
            this.isBST=isBST;
            this.sum=sum;
            this.min=min;
            this.max=max;
        }
    }
    //creating a var maxsum which trace max sum of bst
    public static int maxsum=0;//initially 0

    //function to find
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);

        int sum=(leftInfo.sum+rightInfo.sum+root.data);
        int min=Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        //check is bst or not
        if(leftInfo.max>=root.data || rightInfo.min<=root.data){
            return new Info(false,sum,min,max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxsum=Math.max(maxsum,sum);
            return new Info(true,sum,min,max);
        }
        return new Info(false,sum,min,max);
    }
    public static void main(String[] args) {
        /*GIVEN TREE
               4
              / 
             3   
            / \    
           1   2
        */
        Node root=new Node(4);
        root.left=new Node(3);
        root.left.left=new Node(1);
        root.left.right=new Node(2);
        root.right=null;
        Info info=largestBST(root);
        System.out.println("Largest sum of BST in BT : "+maxsum);
        
    }
}
