//find key in rotated sorted array
public class arr2{
    public static int search(int arr[], int key) {
        // Write your code here.
        int pivot=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i+1]<arr[i]){
                pivot=i;
                break;
            }
        }
        System.out.println("Pivot is :"+pivot);
        //4,5,1,2,3 pivot=5 
        while(pivot>-1 && pivot<arr.length){
            if(arr[pivot]==key){
                return pivot;
            }
    
            if(arr[pivot]>key){
                pivot--;
            }

            if(arr[pivot]<key){
                pivot++;
            }
        }
    return -1;
    }
    public static void main(String[] args) {
        int arr[]={4,5,1,2,3};
        int key=2;
        System.out.println(search(arr, key));

    }
}