class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        int k=1;
        while (j<nums.length){
            if (nums[i]!=nums[j]){
                nums[k]=nums[j];
                i++;
                k++;
            }
            else{
                j++;
            }
        }
        return k;
    }
}