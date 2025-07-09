class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=0;
        int count=0;
        for (int i:nums){
            if (i==1) count++;
            else{
                maxCount=Math.max(maxCount,count);
                count=0;
            }
        }
        maxCount=Math.max(maxCount,count);
        return maxCount;
    }
}