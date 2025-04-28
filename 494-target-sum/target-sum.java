class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> memo=new HashMap<>();
        return findTargetSumWaysHelper(0,nums,0,target,memo);
    }
    public int findTargetSumWaysHelper(int index,int[] nums,int sum, int target,Map<String,Integer> memo){
        if (index==nums.length){
            if (sum==target) return 1;
            else return 0;
        }
        String key=index+","+sum;
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        int add=findTargetSumWaysHelper(index+1,nums,sum+nums[index],target,memo);
        int sub=findTargetSumWaysHelper(index+1,nums,sum-nums[index],target,memo);
        memo.put(key,add+sub);
        return memo.get(key);
    }
}