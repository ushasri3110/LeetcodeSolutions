class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j = j + 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                char sc=s.charAt(i-1);
                char pc=p.charAt(j-1);
                if (pc=='.' || sc==pc){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if (pc=='*'){
                    char prevPc=p.charAt(j-2);
                    if (prevPc=='.' || prevPc==sc){
                        dp[i][j]=dp[i][j-2] || dp[i-1][j];
                    }
                    else{
                        dp[i][j]=dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}