class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxValue=Integer.MIN_VALUE;
        int sum=0;
        Set<Integer> set=new HashSet<>();
        int start=0;
        int end=0;
        while (end<nums.length){
            if (!set.contains(nums[end])){
                sum+=nums[end];
                set.add(nums[end]);
                maxValue=Math.max(sum,maxValue);
            }
            else{
                while (nums[start]!=nums[end]){
                    set.remove(nums[start]);
                    sum-=nums[start];
                    start++;
                }
                start++;
            }
            end++;
        }
        return maxValue;
    }
}