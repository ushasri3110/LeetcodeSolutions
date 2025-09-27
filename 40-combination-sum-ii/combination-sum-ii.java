class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationHelper(0,candidates,target,new ArrayList<>());
        return res;
    }
    public void combinationHelper(int idx,int[] nums,int target,List<Integer> c){
        if (target==0){
            res.add(new ArrayList<>(c));
            return;
        }
        for (int i=idx;i<nums.length;i++){
            if (i>idx && nums[i]==nums[i-1]) continue;
            if (nums[i]>target) break;
            c.add(nums[i]);
            combinationHelper(i+1,nums,target-nums[i],c);
            c.remove(c.size()-1);
        }
    }
}