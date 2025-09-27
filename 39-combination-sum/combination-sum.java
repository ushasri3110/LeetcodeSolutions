class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationHelper(0,candidates,target,new ArrayList<>());
        return res;
    }
    private void combinationHelper(int idx,int[] candidates,int target,List<Integer> c){
        if (idx==candidates.length){
            if (target==0) res.add(new ArrayList<>(c));
            return;
        }
        if (target>=candidates[idx]){
            c.add(candidates[idx]);
            combinationHelper(idx,candidates,target-candidates[idx],c);
            c.remove(c.size()-1);
        }
        combinationHelper(idx+1,candidates,target,c);
    }
}