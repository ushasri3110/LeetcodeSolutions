class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        for(int j=1;j<nums.length;j++){
            if (nums[j]!=nums[i-1]) nums[i++]=nums[j];
        }
        return i;
    }
}