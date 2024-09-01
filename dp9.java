//LONGEST COMMON SUBSTRING (variation of lcs) O(n*m)
public class dp9 {
    public static void printDP(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int longestcommonsubstr(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        int ans=0;
        //initialisation
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j]=0;//resets to 0 
                }
            }
        }
        printDP(dp);
    return ans;
    }

    public static void main(String args[]){
        String str1="ABGE";
        String str2="ABDE";
        System.out.println(longestcommonsubstr(str1, str2));
    }
}
