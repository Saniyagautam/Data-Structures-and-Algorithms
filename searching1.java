//linear search O(n) -->Worst O(1)-->Best  Space-->O(1)
public class searching1 {
    public static int linearSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int key=3;
        System.out.println(linearSearch(arr,key));
    }
}
