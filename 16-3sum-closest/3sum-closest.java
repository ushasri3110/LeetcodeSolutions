class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int minDiff=Integer.MAX_VALUE;
        int closestSum=0;
        for (int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while (j<k){
                int currentSum=nums[i]+nums[j]+nums[k];
                if (currentSum==target){
                    return target;
                }
                else if (currentSum<target){
                    j++;
                }
                else{
                    k--;
                }
                int diff=Math.abs(currentSum-target);
                if (diff<minDiff){
                    minDiff=diff;
                    closestSum=currentSum;
                }
                
            }
        }
        return closestSum;
    }
}