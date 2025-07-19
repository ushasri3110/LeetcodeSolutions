class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int topLeft = j > 0 ? dp[j - 1] : Integer.MAX_VALUE;
                int top = dp[j];
                int topRight = j < n - 1 ? dp[j + 1] : Integer.MAX_VALUE;
                temp[j] = matrix[i][j] + Math.min(topLeft, Math.min(top, topRight));
            }
            dp = temp; 
        }
        int minPathSum = Integer.MAX_VALUE;
        for (int val : dp) {
            minPathSum = Math.min(minPathSum, val);
        }

        return minPathSum;
    }
}