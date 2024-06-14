class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int min_moves=0;
        for (int i=1;i<nums.length;i++){
           if (nums[i]<=nums[i-1]){
            min_moves+=nums[i-1]-nums[i]+1;
            nums[i]=nums[i-1]+1;
           }
        }
        return min_moves;
    }
}