//Calculating Fibonacci using DP
//using MEMOIZATION 
//using TABULATION

public class dp1{
    public static int fib(int n,int[] dp){
        if(n==1||n==0){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];//if not 0 already calculated 
        }
        dp[n]=fib(n-1,dp)+fib(n-2,dp);//else calculate 
        return dp[n];
    }
    public static int fibTabulation(int n){
        int dp[]=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=5;
        int[] dp=new int[n+1];//intializes with [0,0,0,0,0,0]
        // System.out.println(fib(n,dp));
        System.out.println(fibTabulation(n));
    }
}