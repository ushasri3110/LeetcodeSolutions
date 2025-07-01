class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE,res=-1;
        for (int i:bloomDay){
            if (i<low) low=i;
            if (i>high) high=i;
        }
        while (low<=high){
            int mid=low+(high-low)/2;
            if (canPlace(bloomDay,m,k,mid)){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
    public boolean canPlace(int[] bloomDay,int m,int k,int day){
        int bloomed=0;
        int bouquets=0;
        for (int i:bloomDay){
            if (i<=day){
                bloomed++;
            }
            else{
                bouquets+=bloomed/k;
                bloomed=0;
            }
        }
        bouquets+=bloomed/k;
        return bouquets>=m;
    }
}