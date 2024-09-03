//Creating a segment tree for MAX O(n)
//Find max of elements in a range O(logn)
//update the segment tree O(logn)
public class segmentTrees2 {
    static int[] tree;
    //Create segment tree
    public static void init(int n){
        tree=new int[4*n];
    }
    public static void buildTree(int i,int si,int sj,int[] arr){
        if(si==sj){
            tree[i]=arr[si];//leaf nodes
            return;
        }
        int mid=(si+sj)/2;
        buildTree(2*i+1, si, mid, arr);
        buildTree(2*i+2, mid+1, sj, arr);
        tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
    }
    //Query
    public static int getMax(int[] arr,int qi,int qj){
        int n=arr.length;
        return getMaxutil(0, 0, n-1,qi, qj);
    }
    public static int getMaxutil(int i,int si,int sj,int qi,int qj){
        if(si>qj|| sj<qi ){
            return Integer.MIN_VALUE;//no overlap
        }
        else if(si>=qi && sj<=qj){
            return tree[i];//complete overlap
        }
        else{//complete overlap
            int mid=(si+sj)/2;
            int leftMax=getMaxutil(2*i+1, si, mid, qi, qj);
            int rightMax=getMaxutil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(leftMax,rightMax);
        }
    }
    //update 
    public static void update(int arr[],int idx,int newVal){
        arr[idx]=newVal;
        int n=arr.length;
        updateUtil(0, 0, n-1, idx, newVal);
    }
    public static void updateUtil(int i,int si,int sj,int idx,int newVal){
        if(idx<si || idx>sj){//non overlap
            return;
        }
        if(si==sj){
            tree[i]=newVal;//at leaf node replace the value
        }
        if(si!=sj){//ar leaf node Check for max value
            tree[i]=Math.max(tree[i],newVal);
            int mid=(si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
        }
    }

    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        init(n);
        buildTree(0, 0, n-1, arr);
        // for(int i=0;i<tree.length;i++){
        //     System.out.print(tree[i]+" ");
        // }
        System.out.println(getMax(arr, 2, 5));
        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));

    }
}
