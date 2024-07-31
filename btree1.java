//create tree using preorder
//traverse tree using preorder,inorder,postorder
public class btree1 {
    //class for nodes
    static class Node{
        //var
        int data;
        Node left;
        Node right;
        //constructor
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    //class for binarytree
    static class BinaryTree{
        static int idx=-1;//static so that recursively do not renewed
        //function to call recursively
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;//leaf node
            }
            Node newNode=new Node(nodes[idx]);//create obj for node
            newNode.left=buildTree(nodes);//recursively call fn 
            newNode.right=buildTree(nodes);

            return newNode;
        }
        //traverse the tree in preorder 

        public static void preOrder(Node root){
            if(root==null){
                return ;
                
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        //traverse the tree in inorder 

        public static void inOrder(Node root){
            if(root==null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        //traverse the tree in postorder
        public static void postOrder(Node root){
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

    }
    
    
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();//obj
        Node root=tree.buildTree(nodes);
        tree.preOrder(root);
        System.out.println(" ");
        tree.inOrder(root);
        System.out.println(" ");
        tree.postOrder(root);

    }
    
}
