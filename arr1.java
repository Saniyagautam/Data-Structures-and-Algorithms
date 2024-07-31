//rotate an array by k places
/*-->reverse the arr
-->reverse the front arr by k (0 to k-1)
-->reverse the k to end(k to n-1) */
public class arr1{
    public static void reverse(int nums[],int lp,int rp){
        while(lp<rp){
           int temp=nums[lp];
           nums[lp]=nums[rp];
           nums[rp]=temp;
           lp++;
           rp--;
       }
       
   }
   public static  void rotate(int[] nums, int k) {
       k=k%nums.length;//k shud be small or equal to lenggth of arr
       
       int n=nums.length;
       reverse(nums,0,n-1);
       //rotate first k elements
       reverse(nums,0,k-1);
       
       //rotate n-k elements
       reverse(nums,k,n-1);
       
       for(int i=0;i<n;i++){
           System.out.print(nums[i]+" ");
       }
       
   }
   
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        int k=3;
        rotate(arr, k);
    }
}