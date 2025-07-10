class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(k,n,res,new ArrayList<>(),1);
        return res;
    }
    public void backtrack(int k,int rem,List<List<Integer>> res,List<Integer> current,int start){
        if (current.size()==k && rem==0){
            res.add(new ArrayList<>(current));
            return;
        }
        if (current.size() > k || rem < 0) {
            return;
        }
        for (int i=start;i<=9;i++){  
            current.add(i);
            backtrack(k,rem-i,res,current,i+1);
            current.remove(current.size()-1);
        }
    }
}