class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 100000;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    if (i>0) res[i][j]=Math.min(res[i][j],1+res[i-1][j]);
                    if (j>0) res[i][j]=Math.min(res[i][j],1+res[i][j-1]);
                }
            }
        }
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (mat[i][j]!=0){
                    if (i<m-1) res[i][j]=Math.min(res[i][j],1+res[i+1][j]);
                    if (j<n-1) res[i][j]=Math.min(res[i][j],1+res[i][j+1]);
                }
            }
        }
        return res;
    }
}