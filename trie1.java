//insertion and searching in trie O(L)->L is the longest string
public class trie1{
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;//end of word
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;//initialise with null
            }
        }
    }
    //create root (empty)
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static boolean search(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    public static void main(String args[]){
        String words[]={"thee","their","there","any"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(search("any"));
        System.out.println(search("an"));

    }
}
