class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        int[][] res = new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j]==0){
                    res[i][j]=0;
                    q.offer(new int[]{i,j,0});
                }
                else{
                    res[i][j] = 100000;
                }
            }
        }
        while (!q.isEmpty()){
            int[] top=q.poll();
            int r=top[0];
            int c=top[1];
            int d=top[2];
            for (int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if (nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]!=0){
                    mat[nr][nc]=0;
                    res[nr][nc]=d+1;
                    q.offer(new int[]{nr,nc,d+1});
                }
            }
        }
        return res;
    }
}