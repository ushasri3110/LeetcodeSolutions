class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int currentEnd=0;
        int farthest=0;
        for (int i=0;i<nums.length-1;i++){
            farthest=Math.max(i+nums[i],farthest);
            if (i==currentEnd){
                jumps++;
                currentEnd=farthest;
            }
        }
        return jumps;
    }
}