class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i=0;i<(n+1)/2;i++){
            for (int j=0;j<n/2;j++){
                int temp=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=matrix[i][j];
                matrix[i][j]=temp;
                System.out.println(i+" "+j);
            }
        }
    }
}