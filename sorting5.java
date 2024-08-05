//Counting Sort O(n)
public class sorting5{
    public static void countingSort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);
        }
        int tempArr[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            tempArr[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<tempArr.length;i++){
            while(tempArr[i]>0){
                arr[j]=i;
                j++;
                tempArr[i]--;
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
        countingSort(arr);
        printArr(arr);
    }

}
