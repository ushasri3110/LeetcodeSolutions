class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for (int i=0;i<m;i++){
            if (grid[i][0]==1) dfs(i,0,grid,m,n);
            if (grid[i][n-1]==1) dfs(i,n-1,grid,m,n);
        }

        for (int j=0;j<n;j++){
            if (grid[0][j]==1) dfs(0,j,grid,m,n);
            if (grid[m-1][j]==1) dfs(m-1,j,grid,m,n);
        }

        for (int i=1;i<m-1;i++){
            for (int j=1;j<n-1;j++){
                if (grid[i][j]==1) ans++;
            }
        }
        return ans;
    }
    private void dfs(int row,int col,int[][] grid,int m,int n){
        if (row<0 || row>=m || col<0 || col>=n || grid[row][col]==0) return;
        grid[row][col]=0;
        dfs(row-1,col,grid,m,n);
        dfs(row+1,col,grid,m,n);
        dfs(row,col+1,grid,m,n);
        dfs(row,col-1,grid,m,n);
    }
}