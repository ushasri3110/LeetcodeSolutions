class Solution {
    public int numMagicSquaresInside(int[][] grid) {
       int count=0;
       int row_count=grid.length;
       int col_count=grid[0].length;
       for (int i=0;i+2<row_count;i++){
        for (int j=0;j+2<col_count;j++){
            if (isMagicSquare(i,j,grid)){
                count++;
            }
        }
       }
       return count;
    }
    public boolean isMagicSquare(int i,int j,int[][] grid){
        boolean visited[]=new boolean[10];
        for (int row=0;row<3;row++){
            for (int col=0;col<3;col++){
                int num=grid[i+row][j+col];
                if (num<1 || num>9){
                    return false;
                }
                if (visited[num]){
                    return false;
                }
                else{
                    visited[num]=true;
                }
            }
        }
        int d1=grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        int d2=grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
        if (d1!=d2){
            return false;
        }
        int r1=grid[i][j]+grid[i][j+1]+grid[i][j+2];
        int r2=grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
        int r3=grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
        if (r1!=r2 || r1!=r3 || r2!=r3){
            return false;
        }
        if (r1!=d1){
            return false;
        }

        int c1=grid[i][j]+grid[i+1][j]+grid[i+2][j];
        int c2=grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
        int c3=grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];
        if (c1!=c2 || c1!=c3 || c2!=c3){
            return false;
        }
        if (c1!=r1 || c1!=d1){
            return false;
        }

        return true;
    }
}