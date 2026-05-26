class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        // int xor=0;
        // for (int i=0;i<n;i++){
        //     xor^=nums[i];
        //     xor^=i;
        // }
        // xor^=n;
        // return xor;
        int ans= n*(n+1)/2;
        for (int i:nums){
            ans-=i;
        }
        return ans;
    }
}