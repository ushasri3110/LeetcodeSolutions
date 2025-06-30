class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        int result=0;
        for (int w:weights){
            low=Math.max(low,w);
            high+=w;
        }
        while (low<=high){
            int mid=low+(high-low)/2;
            if (canShip(weights,mid,days)){
                result=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return result;
    }
    private boolean canShip(int[] weights,int mid,int days){
        int currentSum=0;
        int numDays=1;
        for (int w:weights){
            if (currentSum+w > mid){
                currentSum=w;
                numDays++;
            }
            else{
                currentSum+=w;
            }
        }
        return numDays<=days;
    }
}