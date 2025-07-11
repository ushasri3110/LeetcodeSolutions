class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i=1;i<=numRows;i++){
            List<Integer> row=new ArrayList<>();
            for (int j=1;j<=i;j++){
                int val=ncr(i-1,j-1);
                row.add(val);
            }
            res.add(row);
        }
        return res;
    }
    public int ncr(int n,int r){
        int res=1;
        for (int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
}