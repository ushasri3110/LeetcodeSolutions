class Solution {
    int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int cost=0;
        int[][] minCost=new int[rows][cols];
        for (int row=0;row<rows;row++){
            Arrays.fill(minCost[row],Integer.MAX_VALUE);
        }
        Queue<int[]> queue=new LinkedList<>();
        dfs(grid,0,0,minCost,cost,queue);
        while (!queue.isEmpty()){
            cost++;
            int levelSize=queue.size();
            while (levelSize-->0){
            int[] curr=queue.poll();
            int row=curr[0];
            int col=curr[1];
            for (int dir=0;dir<4;dir++){
                dfs(grid,row+dirs[dir][0],col+dirs[dir][1],minCost,cost,queue);
            }
            }
        }
        return minCost[rows-1][cols-1];
    }
    public void dfs(int[][] grid,int row,int col,int[][] minCost,int cost,Queue<int[]> queue){
        if (!(row>=0 && col>=0 && row<minCost.length && col <minCost[0].length && minCost[row][col]==Integer.MAX_VALUE)){
            return;
        }
        minCost[row][col]=cost;
        queue.offer(new int[]{row,col});
        int nextDir=grid[row][col]-1;
        dfs(grid,row+dirs[nextDir][0],col+dirs[nextDir][1],minCost,cost,queue);
    }
}