class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(0,new ArrayList<>(),nums);
        return res;
    }
    public void subsetsHelper(int index,List<Integer> current,int[] nums){
        if (index ==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        subsetsHelper(index+1,current,nums);
        current.remove(current.size()-1);
        subsetsHelper(index+1,current,nums);
    }
}