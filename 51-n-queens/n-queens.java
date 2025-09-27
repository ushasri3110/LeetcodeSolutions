class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for (char[] ch:board){
            Arrays.fill(ch,'.');
        }
        solve(0,board,n);
        return res;
    }
    private void solve(int col,char[][] board,int n){
        if (col==n){
            List<String> b=new ArrayList<>();
            for (char[] ch:board){
                b.add(String.valueOf(ch));
            }
            res.add(b);
            return;
        }
        for (int row=0;row<n;row++){
            if (isSafe(row,col,board,n)){
                board[row][col]='Q';
                solve(col+1,board,n);
                board[row][col]='.';
            }
        }
    }
    private boolean isSafe(int row,int col,char[][] board,int n){
        int r=row;
        int c=col;
        while (col>=0){
            if (board[row][col]=='Q') return false;
            col--;
        }
        row=r;
        col=c;
        while (row>=0 && col>=0){
            if (board[row][col]=='Q') return false;
            col--;
            row--;
        }
        row=r;
        col=c;
        while (row<n && col>=0){
            if (board[row][col]=='Q') return false;
            row++;
            col--;
        }
        return true;
    }
}