class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest=0;
        int min_diff=Integer.MAX_VALUE;
        for (int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                int currentSum=nums[i]+nums[j]+nums[k];
                if (currentSum==target){
                    return target;
                }
                else if (currentSum>target){
                    k--;
                }
                else{
                    j++;
                }
                int diff=Math.abs(target-currentSum);
                if (diff<min_diff){
                    min_diff=diff;
                    closest=currentSum;
                }
            }
        }
        return closest;
    }
}