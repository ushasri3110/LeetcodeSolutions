class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLength=0;
        int[] dp=new int[nums.length];
        for (int i=0;i<dp.length;i++){
            dp[i]=1;
        }
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
        }
        for (int i=0;i<dp.length;i++){
            if (dp[i]>maxLength){
                maxLength=dp[i];
            }
        }
        return maxLength;
    }
}