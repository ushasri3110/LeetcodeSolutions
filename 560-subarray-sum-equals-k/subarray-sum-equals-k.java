class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: prefix sum 0 occurs once

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int req = sum - k;
            count += map.getOrDefault(req, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}