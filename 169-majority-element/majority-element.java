class Solution {
    public int majorityElement(int[] nums) {
        int majority=0;
        int votes=0;
        for (int i=0;i<nums.length;i++){
            if (votes==0){
                majority=nums[i];
                votes=1;
            }
            else if (nums[i]==majority){
                votes++;
            }
            else{
                votes--;
            }
        }
        return majority;
    }
}