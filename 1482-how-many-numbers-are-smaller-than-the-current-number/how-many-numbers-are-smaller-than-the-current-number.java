class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res=new int[nums.length];
        int[] buckets=new int[101];
        for (int i:nums){
            buckets[i]++;
        }
        for (int i=1;i<buckets.length;i++){
            buckets[i]=buckets[i]+buckets[i-1];
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0) res[i]=0;
            else res[i]=buckets[nums[i]-1];
        }
        return res;
    }
}