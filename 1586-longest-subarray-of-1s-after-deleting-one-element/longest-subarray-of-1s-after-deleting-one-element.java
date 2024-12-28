class Solution {
    public int longestSubarray(int[] nums) {
        int longest=0;
        int j=0;
        int c=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c++;
            }
            while(c>1){
                if (nums[j]==0){
                    c--;
                }
                j++;
            }
            longest=Math.max(longest,i-j);
        }
        return longest;
    }
}