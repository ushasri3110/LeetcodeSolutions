class Solution {
    public int waysToSplitArray(int[] nums) {
        int count=0;
        long rightSum=0;
        for (int i:nums){
            rightSum+=i;
        }
        long leftSum=0;
        for (int i=0;i<nums.length-1;i++){
            leftSum+=nums[i];
            rightSum-=nums[i];
            if (leftSum>=rightSum){
                count++;
            }
        }
        return count;
    }
}