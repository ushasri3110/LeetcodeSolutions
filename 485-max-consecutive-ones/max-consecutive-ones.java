class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes=0;
        int current=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1){
                current++;
                maxOnes=Math.max(maxOnes,current);
            }
            else{
                current=0;
            }
        }
        return maxOnes;
    }
}