//CLIMBING STAIRS (fibonacci)
/*
1. Using recursion O(2^n)
2. Memoization O(n)
3. Tabulation O(n)
 */
import java.util.*;
public class dp2 {
    //Recursion
    public static int climbingStairs(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return climbingStairs(n-1)+climbingStairs(n-2);
    }
    //Memoization
    public static int climbingStairsMem(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n]=climbingStairsMem(n-1,dp)+climbingStairsMem(n-2,dp);
        return dp[n];
    }
    //Tabulation
    public static int climbingStairsTab(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;
            }
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];//[0,0,0,0,0]
        Arrays.fill(dp,-1);//[-1,-1,-1,-1]
        // System.out.println(climbingStairsMem(n,dp));
        System.out.println(climbingStairsTab(n));
    }
}
