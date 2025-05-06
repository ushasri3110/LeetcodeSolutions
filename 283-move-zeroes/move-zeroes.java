class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        for (int i:nums){
            if (i!=0){
                nums[j++]=i;
            }
        }
        while (j<nums.length){
            nums[j++]=0;
        }
        
    }
}