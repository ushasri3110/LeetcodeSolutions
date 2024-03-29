class Solution {
    public int longestSubarray(int[] nums) {
        int longest=0;
        int zeroCount=0;
        int start=0;
        
        for (int j=0; j<nums.length; j++) {
            if (nums[j] == 0) {
                zeroCount++;
            }
            
            while (zeroCount > 1) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            
            longest = Math.max(longest, j - start); 
        }
        
        return longest;
    }
}
