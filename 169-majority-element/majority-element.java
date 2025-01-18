class Solution {
    public int majorityElement(int[] nums) {
        int candidate=0;
        int count=0;
        for (int i:nums){
            if (candidate==i){
                count++;
            }
            else if (count==0){
                candidate=i;
            }
            else{
                count--;
            }
        }
        count=0;
        for (int i:nums){
            if (candidate==i){
                count++;
            }
        }
        return count>nums.length/2?candidate:-1;
    }
}