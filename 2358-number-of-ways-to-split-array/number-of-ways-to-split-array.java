class Solution {
    public int waysToSplitArray(int[] nums) {
        int count=0;
        long total=0;
        long prefixSum=0;
        long suffixSum=0;
        for (int i:nums){
            total+=i;
        }
        for (int i=0;i<nums.length-1;i++){
            prefixSum+=nums[i];
            suffixSum=total-prefixSum;
            if (prefixSum>=suffixSum) count++;
        }
        return count;
    }
}