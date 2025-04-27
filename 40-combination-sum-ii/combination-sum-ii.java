class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumHelper(0,new ArrayList<>(),0,candidates,target);
        return res;
    }
    public void combinationSumHelper(int index,List<Integer> current,int sum,int[] candidates,int target){
        if (sum > target) return;
        if (index==candidates.length){
            if (sum==target){
                res.add(new ArrayList<>(current));
            }
            return;
        }
        current.add(candidates[index]);
        sum+=candidates[index];
        combinationSumHelper(index+1,current,sum,candidates,target);
        current.remove(current.size()-1);
        sum-=candidates[index];
        while (index+1 < candidates.length && candidates[index]==candidates[index+1]){
            index++;
        }
        combinationSumHelper(index+1,current,sum,candidates,target);
    }
}