class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets(0,nums,new ArrayList<>());
        return res;
    }
    private void subsets(int idx,int[] nums,List<Integer> c){
        res.add(new ArrayList<>(c));
        for (int i=idx;i<nums.length;i++){
            if (i>idx && nums[i]==nums[i-1]) continue;
            c.add(nums[i]);
            subsets(i+1,nums,c);
            c.remove(c.size()-1);
        }
    }
}