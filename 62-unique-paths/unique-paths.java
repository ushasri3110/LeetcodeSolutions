class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp=new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    temp[j]=1;
                else {
                    int up = dp[j];  
                    int left = (j > 0) ? temp[j - 1] : 0; 
                    temp[j] = up + left;
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}