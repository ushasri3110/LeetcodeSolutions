class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int req=target-nums[i];
            if (map.containsKey(req)&&map.get(req)!=i){
                return new int[]{i,map.get(req)};
            }
        }
        return new int[2];
    }
}