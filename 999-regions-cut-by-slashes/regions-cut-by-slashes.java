class Solution {
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int regionsBySlashes(String[] grid) {
        int res=0;
        int gridSize=grid.length;
        int[][] expandedGrid=new int[gridSize*3][gridSize*3];
        for (int i=0;i<gridSize;i++){
            for (int j=0;j<gridSize;j++){
                int baseRow=i*3;
                int baseCol=j*3;
                if (grid[i].charAt(j)=='/'){
                    expandedGrid[baseRow][baseCol+2]=1;
                    expandedGrid[baseRow+1][baseCol+1]=1;
                    expandedGrid[baseRow+2][baseCol]=1;
                }
                if (grid[i].charAt(j)=='\\'){
                    expandedGrid[baseRow][baseCol]=1;
                    expandedGrid[baseRow+1][baseCol+1]=1;
                    expandedGrid[baseRow+2][baseCol+2]=1;
                }
            }
        }
        for (int i=0;i<gridSize*3;i++){
            for (int j=0;j<gridSize*3;j++){
                if (expandedGrid[i][j]==0){
                    fillZeros(expandedGrid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    public void fillZeros(int[][] expandedGrid,int row,int col){
        Queue<int[]> queue=new LinkedList<>();
        expandedGrid[row][col]=1;
        queue.add(new int[]{row,col});
        while (!queue.isEmpty()){
            int[] current=queue.poll();
            for (int[] dir:directions){
                int newRow=current[0]+dir[0];
                int newCol=current[1]+dir[1];
                if (isValid(expandedGrid,newRow,newCol)){
                    expandedGrid[newRow][newCol]=1;
                    queue.add(new int[]{newRow,newCol});
                }
            }
        }
    }
    public boolean isValid(int[][] expandedGrid,int i,int j){
        int n=expandedGrid.length;
        return (i>=0 && j>=0 && i<n && j<n && expandedGrid[i][j]==0);
    }
}