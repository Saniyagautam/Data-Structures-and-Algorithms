//partition arr into 2 parts such that sum1-sum2=0 (variation of 0-1 Knapsack) O(nW)
//using Tabulation
public class dp19 {
    public static boolean minPartioning(int[] arr){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int W=sum/2;
        int dp[][]=new int[n+1][W+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                //valid
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }
                else{//invalid
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return W==dp[n][W];
        
    }
    public static void main(String[] args) {
        int arr[]={1,2,8};
        System.out.println(minPartioning(arr));
    }
}
