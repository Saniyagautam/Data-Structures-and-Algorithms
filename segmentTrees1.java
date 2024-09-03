//Creating segment tree O(n)
//Query on segment trees for 1 query O(logn)
//Update in segment trees O(logn)
public class segmentTrees1 {
    static int tree[];
    public static void init(int n){
        tree=new int[4*n];
    }
    public static int buildst(int arr[],int i,int start,int end){
        if(start==end){
            tree[i]=arr[start];
            return arr[start];
        }
        int mid=(start+end)/2;
        buildst(arr, 2*i+1, start, mid);//left subtree
        buildst(arr, 2*i+2, mid+1, end);//right subtree
        tree[i]=tree[2*i+1]+tree[2*i+2];
        return tree[i];
    }
    //Query
    public static int getsumUtil(int i,int si,int sj,int qi,int qj){
        if(qj<=si || qi>=sj){
            return 0;//No overlap
        }
        else if(si>=qi && sj<=qj){
            return tree[i];//complete overlap
        }
        else{//partially overlap
            int mid=(si+sj)/2;
            int left=getsumUtil(2*i+1, si, mid, qi, qj);
            int right=getsumUtil(2*i+2, mid+1, sj, qi, qj);
            return left+right;
        }
    }
    public static int getsum(int arr[],int qi,int qj){
        return getsumUtil(0, 0, arr.length-1, qi, qj);
    }
    //Update 
    public static void updateUtil(int i,int si,int sj,int idx,int diff){
        if(idx>sj || idx<si){
            return;
        }
        tree[i]+=diff;
        if(si!=sj){//non leaf nodes
            int mid=(si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }
    public static void update(int[] arr,int idx,int newVal){
        int diff=newVal-arr[idx];
        arr[idx]=newVal;
        int n=arr.length;
        updateUtil(0, 0, n-1, idx, diff);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        init(arr.length);
        buildst(arr, 0, 0, arr.length-1);
        // for(int i=0;i<tree.length;i++){
        //     System.out.print(tree[i]+" ");
        // }
        System.out.println(getsum(arr, 2, 5));
        update(arr, 2, 2);
        System.out.println(getsum(arr, 2, 5));
    }
}
