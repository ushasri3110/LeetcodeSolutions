class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinations(1,k,n,new ArrayList<>());
        return res;
    }
    private void combinations(int start,int k,int target,List<Integer> c){
        if (target==0 && c.size()==k) res.add(new ArrayList<>(c));
        for (int i=start;i<=9;i++){
            if (c.size()>k || i>target) break;
            c.add(i);
            combinations(i+1,k,target-i,c);
            c.remove(c.size()-1);
        }
    }
}