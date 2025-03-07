//MOUNTAIN RANGES (variation of Catalan) O(n2) 
public class dp16 {
    public static int mountainRanges(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int inside=dp[j];
                int outside=dp[i-j-1];
                dp[i]+=inside*outside;
                //dp[i]+=dp[j]*dp[i-j-1];
            }
        }
    return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(mountainRanges(n));
    }
}
