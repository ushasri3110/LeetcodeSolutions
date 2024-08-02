class Solution {
    public int minSwaps(int[] nums) {
       int n=nums.length;
       int numOnes=0;
       for (int i:nums){
        if (i==1){
            numOnes++;
        }
       }
       if (numOnes==0||numOnes==1 || numOnes==n){
        return 0;
       }
       int zeros=0;
       int i;
       int ans=n;
       for (i=0;i<numOnes;i++){
        if (nums[i]==0){
            zeros++;
        }
       }
       for (int j=0;j<n;i=(i+1)%n,j++){
        if (nums[j]==0){
            zeros--;
        }
        if (nums[i]==0){
            zeros++;
        }
        ans=Math.min(ans,zeros);
       }
       return ans;
    }
}