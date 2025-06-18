class Solution {
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        int numRows=heights.length;
        int numCols=heights[0].length;
        int[][] dist=new int[numRows][numCols];
        for (int i=0;i<numRows;i++){
            for (int j=0;j<numCols;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        while (!pq.isEmpty()){
            int[] current=pq.poll();
            int row=current[0];
            int col=current[1];
            int effort=current[2];
            if (row == numRows - 1 && col == numCols - 1) {
                return effort;
            }
            for (int i=0;i<4;i++){
                int[] dir=directions[i];
                int r=row+dir[0];
                int c=col+dir[1];
                if (r>=0 && r<numRows && c>=0 && c<numCols){
                    int e=Math.abs(heights[row][col]-heights[r][c]);
                    int newEffort=Math.max(e,effort);
                    if (newEffort<dist[r][c]){
                        dist[r][c]=newEffort;
                        pq.offer(new int[]{r,c,newEffort});
                    }
                }
            }
        }
        return 0;
    }
}