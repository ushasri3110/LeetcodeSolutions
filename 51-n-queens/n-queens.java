class Solution {
    List<List<String>> res=new ArrayList<>();
    public boolean isSafe(int row,int col,List<String> board,int n){
        int dupRow=row;
        int dupCol=col;
        while (col>=0){
            if (board.get(row).charAt(col)=='Q') return false;
            col--;
        }
        row=dupRow;
        col=dupCol;
        while (row>=0 && col>=0){
            if (board.get(row).charAt(col)=='Q') return false;
            col--;
            row--;
        }
        row=dupRow;
        col=dupCol;
        while (row<n && col>=0){
            if (board.get(row).charAt(col)=='Q') return false;
            col--;
            row++;
        }
        return true;
    }
    public void solve(int col,List<String> board,int n){
        if (col==n){
            res.add(new ArrayList<>(board));
            return;
        }
        for (int row=0;row<n;row++){
            if (isSafe(row,col,board,n)){
                char[] arr=board.get(row).toCharArray();
                arr[col]='Q';
                board.set(row,new String(arr));
                solve(col+1,board,n);
                arr[col]='.';
                board.set(row,new String(arr));
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<String> board=new ArrayList<>();
        StringBuilder row=new StringBuilder();
        for(int i=0;i<n;i++){
            row.append('.');
        }
        for (int i=0;i<n;i++){
            board.add(row.toString());
        }
        solve(0,board,n);
        return res;
    }
}