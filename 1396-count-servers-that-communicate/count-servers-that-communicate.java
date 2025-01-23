class Solution {
    public int countServers(int[][] grid) {
        int count=0;
        int rowCount[]=new int[grid[0].length];
        int colCount[]=new int[grid.length];
        
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    rowCount[j]++;
                    colCount[i]++;
                }
            }
        }

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    if (rowCount[j]>1 || colCount[i]>1){
                        count++;
                    }
                }
            }
        }

        return count;

    }
}