class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        findTargetSumWaysHelper(0,nums,0,target);
        return count;
    }
    public void findTargetSumWaysHelper(int index,int[] nums,int sum, int target){
        if (index==nums.length){
            if (sum==target){
                count++;
            }
            return;
        }
        sum+=nums[index];
        findTargetSumWaysHelper(index+1,nums,sum,target);
        sum=sum- (2*nums[index]);
        findTargetSumWaysHelper(index+1,nums,sum,target);
    }
}