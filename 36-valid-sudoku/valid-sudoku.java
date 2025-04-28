class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    if (!isValid(i,j,board)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValid(int row,int col,char[][] board){
        for (int i=0;i<9;i++){
            if (i!=row && board[row][col]==board[i][col]){
                return false;
            }
            if (i!=col && board[row][col]==board[row][i]){
                return false;
            }
            int gridRow=3*(row/3)+i/3;
            int gridCol=3*(col/3)+i%3;
            if (gridRow!=row && gridCol!=col && board[gridRow][gridCol]==board[row][col]){
                return false;
            }
        }
        return true;
    }
}