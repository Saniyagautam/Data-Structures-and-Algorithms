//Optimised Bubble Sort Best--> O(n)
public class sorting2 {
    public static void optbubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int swap=0;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap++;
                }
            }
            if(swap==0){
                break;
            }
        }
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String args[]){
        int arr[]={9,8,7,6,5,4,3,1,2};
        optbubbleSort(arr);
        printArr(arr);
    }

}
