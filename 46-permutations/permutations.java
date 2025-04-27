class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permuteHelper(new ArrayList<>(),new boolean[nums.length],nums);
        return res;
    }
    public void permuteHelper(List<Integer> current,boolean[] freq,int[] nums){
        if (current.size()==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!freq[i]){
                current.add(nums[i]);
                freq[i]=true;
                permuteHelper(current,freq,nums);
                current.remove(current.size()-1);
                freq[i]=false;
            }
        }
    }
}