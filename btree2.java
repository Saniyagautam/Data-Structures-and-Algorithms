//levelorder traversal
import java.util.*;
/*
algo
-->cretae q and add root and null
-->get the currNode
   ->if node is null give nextline
       -->if q empty  break
       -->else add null
   ->else is node is other than null
        -->print data of curr node
        -->if left is not null add to q
        -->if right not null add to q
 */
public class btree2 {
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
    //creating a tree
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
    //levelorder traversal
    public static void levelOrder(Node root){
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
                }
            }
            //other element than null
            else{ 
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }

    }
}
public static void main(String[] args) {
    int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    BinaryTree tree=new BinaryTree();
    Node root=tree.buildTree(nodes);
    tree.levelOrder(root);
}
}
