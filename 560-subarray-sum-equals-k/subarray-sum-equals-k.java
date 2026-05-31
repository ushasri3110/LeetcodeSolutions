class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0,sum=0;
        for (int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            int rem=sum-k;
            count+=map.getOrDefault(rem,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}