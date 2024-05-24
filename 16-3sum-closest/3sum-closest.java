class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int min_diff=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum=nums[i]+nums[j]+nums[k];
                if (sum==target){
                    return target;
                }
                else if (sum<target){
                    j++;
                }
                else{
                    k--;
                }
                int diff=Math.abs(sum-target);
                if (diff<min_diff){
                    min_diff=diff;
                    closest=sum;
                }
            }
        }
        return closest;
    }
}