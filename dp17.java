
/*
Recursion
Memoization O(n2)
 */
public class dp17 {
    public static int mcm(int arr[],int i,int j){
        if(i==j){
            return 0;//multiply single matrix cost=0
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=mcm(arr, i, k);
            int cost2=mcm(arr, k+1, j);
            int cost3=arr[i-1]*arr[k]*arr[j];
            int finalCost=cost1+cost2+cost3;
            ans=Math.min(ans,finalCost);
        }
        return ans;
    }
    //Memoization
    public static int mcmMem(int[] arr,int i,int j,int[][] dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];//already calculated
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=mcmMem(arr, i, k, dp);
            int cost2=mcmMem(arr, k+1, j, dp);
            int cost3=arr[i-1]*arr[k]*arr[j];
            ans=Math.min(ans,cost1+cost2+cost3);
        }
        return dp[i][j]=ans;

    }
    //Tabulation(idk :|)
    public static int mcmTab(int[] arr){
        int n=arr.length;
        int dp[][]=new int[n][n];
        //initialisation
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        //bottom to up
        for(int len=2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                int j=i+len-1;//col(diagonally)
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(dp[i][j],cost1+cost2+cost3);
                }
            }
        }
    return dp[1][n-1];
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        // int n=arr.length;
        // int dp[][]=new int[n][n];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);//fill row wise
        // }
        // System.out.println(mcmMem(arr,1,n-1, dp));
        System.out.println(mcmTab(arr));
    }
}
