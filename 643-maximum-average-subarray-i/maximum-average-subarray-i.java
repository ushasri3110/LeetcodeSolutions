class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for (int i=0;i<k;i++){
            sum+=nums[i];
        }
        int maxSum=sum;
        int i=0;
        int j=k;
        while (j<nums.length){
            sum-=nums[i];
            i++;
            sum+=nums[j];
            j++;
            maxSum=Math.max(maxSum,sum);
        }
        return (double)maxSum/k;
    }
}