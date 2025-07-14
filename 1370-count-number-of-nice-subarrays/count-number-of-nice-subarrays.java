class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return getCount(nums,k)-getCount(nums,k-1);
    }
    public int getCount(int[] nums,int k){
        if (k<0) return 0;
        int count=0,oddCount=0,start=0;
        for (int end=0;end<nums.length;end++){
            if (nums[end]%2!=0) oddCount++;
            while (oddCount>k){
                if (nums[start]%2!=0) oddCount--;
                start++;
            }
            if (oddCount<=k) count=count+(end-start+1);
        }
        return count;
    }
}