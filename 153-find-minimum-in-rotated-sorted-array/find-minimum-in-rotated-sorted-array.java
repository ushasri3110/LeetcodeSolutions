class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1,minimum=Integer.MAX_VALUE;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (nums[mid]<minimum) minimum=nums[mid];
            if (nums[low]<=nums[mid]){
                minimum=Math.min(nums[low],minimum);
                low=mid+1;
            }
            else{
                minimum=Math.min(minimum,nums[mid+1]);
                high=mid-1;
            }
        }
        return minimum;
    }
}