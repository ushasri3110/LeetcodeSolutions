class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=nums[0];
        int maxSum=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]){
                sum+=nums[i];
            }
            else{
                maxSum=Math.max(maxSum,sum);
                sum=nums[i];
            }
        }
        maxSum=Math.max(maxSum,sum);
        return maxSum;
    }
}