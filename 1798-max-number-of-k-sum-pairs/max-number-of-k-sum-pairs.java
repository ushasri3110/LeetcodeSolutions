class Solution {
    public int maxOperations(int[] nums, int k) {
        int operations=0;
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if (nums[i]+nums[j]==k){
                operations++;
                i++;
                j--;
            }
            else if (nums[i]+nums[j]<k){
                i++;
            }
            else{
                j--;
            }
        }
        return operations;
    }
}