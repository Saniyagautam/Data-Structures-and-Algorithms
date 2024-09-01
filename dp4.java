//Target sum subset (similar to 0-1 knapsack using Tabular) O(n*sum)
public class dp4{
    public static void printDP(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    System.out.println();
    }
    public static boolean targetsumsubsetTab(int arr[],int sum){
        int n=arr.length;
        boolean dp[][]=new boolean [n+1][sum+1];
        //initialises
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                //valid and include
                int v=arr[i-1];
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                //exclude
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        printDP(dp);
    return dp[n][sum];
    }
    public static void main(String[] args) {
        int arr[]={4,2,7,1,3};
        int sum=10;
        System.out.println(targetsumsubsetTab(arr,sum));
    }
}