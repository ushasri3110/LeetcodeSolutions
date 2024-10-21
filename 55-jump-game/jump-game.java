class Solution {
    public boolean canJump(int[] nums) {
        int steps=0;
        int n=nums.length;
        for (int i=0;i<n;i++){
            if (steps<0){
                return false;
            }
            else if (nums[i]>steps){
                steps=nums[i];
            }
            steps--;
        }
        return true;
    }
}