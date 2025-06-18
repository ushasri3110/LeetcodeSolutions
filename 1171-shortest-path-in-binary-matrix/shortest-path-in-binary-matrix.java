class Solution {
    int[][] directions={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        int[][] dist=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=1;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,1});
        while (!q.isEmpty()){
            int[] current=q.poll();
            int row=current[0],col=current[1],distance=current[2];
            for (int i=0;i<8;i++){
                int[] dir=directions[i];
                int r=row+dir[0];
                int c=col+dir[1];
                if (r>=0 && r<n && c>=0 && c<n && grid[r][c]==0){
                    if (distance+1<dist[r][c]){
                        dist[r][c]=distance+1;
                        q.offer(new int[]{r,c,distance+1});
                    }
                }
            }
        }
        return dist[n-1][n-1]==Integer.MAX_VALUE?-1:dist[n-1][n-1];
    }
}