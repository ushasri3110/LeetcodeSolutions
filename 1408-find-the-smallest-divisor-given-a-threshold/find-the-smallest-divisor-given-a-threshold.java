class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1,high=getMax(nums);
        int res=high;
        while (low<=high){
            int mid=low+(high-low)/2;
            int sum=getSum(nums,mid);
            if (sum<=threshold){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
    public int getMax(int[] nums){
        int max=Integer.MIN_VALUE;
        for (int i:nums){
            max=Math.max(i,max);
        }
        return max;
    }
    public int getSum(int[] nums,int mid){
        int sum=0;
        for (int i:nums){
            if (i%mid==0) sum+=(i/mid);
            else sum+=(i/mid)+1;
        }
        return sum;
    }
}