//WILDCARD MATCHING (variation of lcs)  O(n*m)
public class dp13 {
    public static boolean ismatch(String s, String p){
        int n=s.length();
        int m=p.length();
        boolean dp[][]=new boolean[n+1][m+1];
        //initialisation 
        dp[0][0]=true;//when s=' ' and p =' ' thus matched
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;//when pattern is ' '
        }
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
            //else false by default ( in java )
        }
        //bottom to top approach 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
    return dp[n][m];
    }

    public static void main(String args[]){
        String s="bcaa";
        String p="b*****c*?";
        System.out.println(ismatch(s, p));
    }
}
