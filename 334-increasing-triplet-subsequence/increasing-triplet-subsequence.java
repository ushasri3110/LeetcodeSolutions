class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length<3) return false;
        int i=Integer.MAX_VALUE;
        int j=Integer.MAX_VALUE;
        for (int k=0;k<nums.length;k++){
            if (i>=nums[k]) i=nums[k];
            else if (j>=nums[k]) j=nums[k];
            else return true;
        }
        return false;
    }
}