class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE, high=0, ans=-1;
        for (int i:nums) {
        	if (i>low) low=i;
        	high+=i;
        }
        while (low<=high){
            int mid=low+(high-low)/2;
            if (isPossible(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] nums,int k,int maxSum){
        int subarray=1;
        int sum=0;
        for (int i:nums){
            if (sum+i>maxSum){
                subarray++;
                sum=i;
                if (subarray>k) return false;
            }
            else sum+=i;
        }
        return true;
    }
}