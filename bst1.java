
//search in bst O(H) (bigoh of height)
//delete node in bst (3-cases)
    


public class bst1 {
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
    public static boolean search(Node root,int key){
        if(root==null){
            return false;//not found
        }
        if(root.data==key){
            return true;//same as root node 
        }
        if(root.data>key){
            //search left subtree
            return search(root.left, key);
        }
        else{
            //search right subtree
            return search(root.right, key);
        }
    }

    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left=delete(root.left,val);
        }
        else if(root.data<val){
            root.right=delete(root.right,val);
        }
        else{//found the node
            //case 1 -Leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2 - Single Child
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            //case 3-Two Children
            Node IS=findInorderSuccessor(root.right);//find IS
            root.data=IS.data;//replace 
            root.right=delete(root.right, IS.data);//delete 
        }
    return root;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        // if(search(root, 11)){
        //     System.out.println("Found!!!");
        // }
        // else{
        //     System.out.println("Not Found!!!");
        // }
        delete(root, 3);
        inorder(root);

    }
}
