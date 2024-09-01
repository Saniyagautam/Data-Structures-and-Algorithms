//UNBOUNDED KNAPSACK O(nW)
public class dp5 {
    public static void printDP(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int UnboundedknapsackTab(int wt[],int val[],int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];
        //initialisation
        for(int i=0;i<dp.length;i++){//first col with 0
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){//first row with 0
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                //valid
                if(w<=j){
                    //include
                    int incProfit=v+dp[i][j-w];//v+dp[i-1][j-w] ONLY CHANGE IN (i-1) to (i)
                    //exclude 
                    int excProfit=dp[i-1][j];
                    dp[i][j]=Math.max(incProfit,excProfit);
                }
                //not valid 
                else{
                    int excProfit=dp[i-1][j];
                    dp[i][j]=excProfit;
                }
            }
        }
        printDP(dp);
    return dp[n][W];
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(UnboundedknapsackTab(wt, val, W));
    }
}
