import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int req_sum=target-nums[i];
            if (map.containsKey(req_sum)){
                return new int[]{i,map.get(req_sum)};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int[2];
    }
}