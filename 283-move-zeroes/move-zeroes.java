class Solution {
    public void moveZeroes(int[] nums) {
        int start=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[start]=nums[i];
                start++;
            }
        }
        while(start<nums.length){
            nums[start++]=0;
        }
    }
}