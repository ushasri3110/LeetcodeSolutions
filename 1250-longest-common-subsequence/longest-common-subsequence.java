class Solution {
    public int tabulation(int n, int m, String s1, String s2) {
        int[][] dp = new int[n + 1][m + 1];
        
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        
        return dp[n][m];
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        return tabulation(n, m, s1, s2);
    }
}
