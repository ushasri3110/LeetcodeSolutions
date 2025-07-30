class Solution {
    int count=0;
    public int totalNQueens(int n) {
        if (n==1) return 1;
        List<String> board=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<n;i++){
            sb.append(".");
        }
        for (int i=0;i<n;i++){
            board.add(sb.toString());
        }
        solve(0,board,n);
        return count;
    }
    public void solve(int col,List<String> board,int n){
        if (col==n){
            count++;
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
    public boolean isSafe(int row,int col,List<String> board,int n){
        int r=row;
        int c=col;
        while (col>=0){
            if (board.get(row).charAt(col)=='Q') return false;
            col--;
        }
        row=r;
        col=c;
        while (col>=0 && row>=0){
            if (board.get(row).charAt(col)=='Q') return false;
            col--;
            row--;
        }
        row=r;
        col=c;
        while (row<n && col>=0){
            if (board.get(row).charAt(col)=='Q') return false;
            col--;
            row++;
        }
        return true;
    }
}