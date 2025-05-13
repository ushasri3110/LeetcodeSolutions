class Solution {
    public int countServers(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int servers=0;
        int rowCount[]=new int[rows];
        int colCount[]=new int[cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j]==1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j]==1 && (rowCount[i]>1 || colCount[j]>1)){
                    servers++;
                }
            }
        }
        return servers;
    }
}