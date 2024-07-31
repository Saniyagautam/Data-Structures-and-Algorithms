//HEAP SORT o(nlogn) in desc and asc order 
public class heap2 {
    public static void heapify(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int minIdx=i;
        //change sign 
        if(left<size && arr[left]<arr[minIdx]){
            minIdx=left;
        }
        //change sign
        if(right<size && arr[right]<arr[minIdx]){
            minIdx=right;
        }
        if(minIdx!=i){
            //swap
            int temp=arr[i];
            arr[i]=arr[minIdx];
            arr[minIdx]=temp;
            //call for lower levels
            heapify(arr,minIdx, size);
        }
    }
    public static void heapSort(int arr[]){
        //step1 build maxheap
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        //step2 swap largest with last el
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,5,2,4,3};
        heapSort(arr);
        //print arr
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    // public static void heapify(int arr[],int i,int size){
    //     int left=2*i+1;
    //     int right=2*i+2;
    //     int maxIdx=i;
    //     if(left<size && arr[left]>arr[maxIdx]){
    //         maxIdx=left;
    //     }
    //     if(right<size && arr[right]>arr[maxIdx]){
    //         maxIdx=right;
    //     }
    //     if(maxIdx!=i){
    //         //swap
    //         int temp=arr[i];
    //         arr[i]=arr[maxIdx];
    //         arr[maxIdx]=temp;
    //         //call for lower levels
    //         heapify(arr,maxIdx, size);
    //     }
    // }
    // public static void heapSort(int arr[]){
    //     //step1 build maxheap
    //     int n=arr.length;
    //     for(int i=n/2;i>=0;i--){
    //         heapify(arr,i,n);
    //     }
    //     //step2 swap largest with last el
    //     for(int i=n-1;i>0;i--){
    //         int temp=arr[0];
    //         arr[0]=arr[i];
    //         arr[i]=temp;
    //         heapify(arr,0,i);
    //     }
    // }
    // public static void main(String[] args) {
    //     int arr[]={1,5,2,4,3};
    //     heapSort(arr);
    //     //print arr
    //     for(int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]+" ");
    //     }
    // }
    
}
