//ROD CUTTING (Same as unbounded knapsack) O(n*Rodlength)
public class dp7{
    public static void printDp(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int rodCuttingTab(int prices[],int length[],int rodlen){
        int n=prices.length;
        int dp[][]=new int[n+1][rodlen+1];
        //can create 2 diff loops as well 
        for(int i=0;i<n+1;i++){
            for(int j=0;j<rodlen+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<rodlen+1;j++){
                //valid
                if(length[i-1]<=j){
                    dp[i][j]=Math.max(prices[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }
                //invalid
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        printDp(dp);
        return dp[n][rodlen];
    }
    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int prices[]={1,5,8,9,10,17,17,20};
        int rodlen=8;
        System.out.println(rodCuttingTab(prices, length, rodlen));
    }
}
