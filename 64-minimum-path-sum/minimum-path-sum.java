class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = grid[0][0];
                } else {
                    int up = i > 0 ? dp[j] : Integer.MAX_VALUE;
                    int left = j > 0 ? temp[j - 1] : Integer.MAX_VALUE;
                    temp[j] = grid[i][j] + Math.min(up, left);
                }
            }
            dp = temp;
        }

        return dp[n - 1];
    }
}
