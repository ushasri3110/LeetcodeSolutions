class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i:nums) sum+=i;
        if (sum%2!=0) return false;
        int target=sum/2;
        boolean[] memo=new boolean[target+1];
        memo[0]=true;
        if (nums[0]<=target) memo[nums[0]]=true;
        for (int i=1;i<nums.length;i++){
            boolean[] temp=new boolean[target+1];
            temp[0]=true;
            for (int j=1;j<=target;j++){
                boolean notTake=memo[j];
                boolean take=false;
                if (nums[i]<=j){
                    take=memo[j-nums[i]];
                }
                temp[j]=take||notTake;
            }
            memo=temp;
        }
        return memo[target];
    }
}