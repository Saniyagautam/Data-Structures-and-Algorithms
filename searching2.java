//Binary search O(logn) Best-->O(1) worst-->O(logn) 
//Space-->O(1)(iterative) Space-->O(n) (recursive)

import java.util.Arrays;

public class searching2 {
    /*RECURSIVE */
    // public static int binarySearch(int arr[],int key,int si,int ei){
    //     if(si>ei){
    //         return -1;
    //     }
    //     int mid=si+(ei-si)/2;
    //     if(arr[mid]==key){
    //         return mid;
    //     }
    //     else if(key<arr[mid]){
    //         return binarySearch(arr, key,si,mid-1);
    //     }
    //     else{
    //         return binarySearch(arr, key, mid+1, ei);
    //     }
    // }
    /*ITERATIVE */
    public static int binarySearch(int arr[],int key){
        int si=0;
        int ei=arr.length-1;

        int mid=si+(ei-si)/2;
        if(arr[mid]==key){
            return mid;
        }
        else if(key<arr[mid]){
            ei=mid-1;
        }
        else{
            si=mid+1;
        }
    return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int key=3;
        Arrays.sort(arr);
        System.out.println(binarySearch(arr,key));
    }
}
