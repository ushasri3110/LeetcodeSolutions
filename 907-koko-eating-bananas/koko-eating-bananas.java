class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=getMax(piles);
        int res=high;
        while (low<=high){
            int mid=low+(high-low)/2;
            int time=getTime(piles,mid);
            if (time<=h){
                res=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return res;
    }
    private int getMax(int[] piles){
        int max=Integer.MIN_VALUE;
        for (int i:piles){
            if (i>max) max=i;
        }
        return max;
    }
    private int getTime(int[] piles,int k){
        long time=0;
        for (int i:piles){
            time+= (i + (long)k - 1) / k;
        }
        return time > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)time;
    }
}