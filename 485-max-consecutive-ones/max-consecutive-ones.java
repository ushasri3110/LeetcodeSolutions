class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int ones=0;
        for (int i:nums){
            if (i==1){
                ones++;
                ans=Math.max(ones,ans);
            }
            else{
                ones=0;
            }
        }
        return ans;
    }
}