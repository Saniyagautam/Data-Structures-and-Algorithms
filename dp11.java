//EDIT DISTANCE O(n*m) (variation of lcs)
public class dp11 {
    public static void printDP(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int editDistance(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        //initialisation
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        //bottom up 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];//same amt of operation 
                }
                else{
                    int add=dp[i][j-1]+1;
                    int remove=dp[i-1][j]+1;
                    int replace=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(add,Math.min(remove,replace));
                }
            }
        }
        printDP(dp);
    return dp[n][m];
    }
    
    public static void main(String[] args) {
        String str1="horse";
        String str2="ros";
        System.out.println(editDistance(str1, str2));
    }
}
