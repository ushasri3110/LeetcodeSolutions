class Solution {
    public int mySqrt(int x) {
        if (x==0 || x==1){
            return x;
        }
        int left=0;
        int right=x;
        int mid=-1;
        while (left<=right){
           mid=(left+right)/2;
            if ((long)mid*mid>(long)x){
                right=mid-1;
            }
            else if (mid*mid==x){
                return mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return right;
    }
}