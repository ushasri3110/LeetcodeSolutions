class Solution {
    public int rob(int[] nums) {
        if (nums.length<2){
            return nums[0];
        }
        int[] skipFirst=new int[nums.length-1];
        int[] skipLast=new int[nums.length-1];
        for (int i=0;i<nums.length-1;i++){
            skipFirst[i]=nums[i];
            skipLast[i]=nums[i+1];
        }
        int lootSkipFirst=robHelper(skipFirst);
        int lootSkipLast=robHelper(skipLast);
        return Math.max(lootSkipFirst,lootSkipLast);
    }
    private int robHelper(int[] nums){
        if (nums.length<2){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}