class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for (int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }
        for (int i=1;i<n;i++){
            for (int j=0;j<n;j++){
                int minValue=dp[i-1][j];
                if (j-1>=0) minValue=Math.min(dp[i-1][j-1],minValue);
                if (j+1<n) minValue=Math.min(dp[i-1][j+1],minValue);
                dp[i][j]=matrix[i][j]+minValue;
            }
        }
        int result=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }
        return result;
    }
}