class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;

        int[] increasing = new int[n];
        int[] decreasing = new int[n];
        increasing[0] = 1;
        decreasing[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing[i] = increasing[i - 1] + 1;
            } else {
                increasing[i] = 1;
            }

            if (nums[i] < nums[i - 1]) {
                decreasing[i] = decreasing[i - 1] + 1;
            } else {
                decreasing[i] = 1;
            }
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.max(increasing[i], decreasing[i]));
        }
        return max;
    }
}