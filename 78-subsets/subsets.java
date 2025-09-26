class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(0,nums,new ArrayList<>());
        return res;
    }
    public void subsetsHelper(int idx,int[] nums,List<Integer> current){
        if (idx>=nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[idx]);
        subsetsHelper(idx+1,nums,current);
        current.remove(current.size()-1);
        subsetsHelper(idx+1,nums,current);
    }
}