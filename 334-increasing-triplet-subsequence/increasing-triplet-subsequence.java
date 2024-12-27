class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int i=Integer.MAX_VALUE;
        int j=Integer.MAX_VALUE;
        for (int a=0;a<nums.length;a++){
            if (nums[a]<=i){
                i=nums[a];
            }
            else if(nums[a]<=j){
                j=nums[a];
            }
            else{
                return true;
            }
        }
        return false;
    }
}