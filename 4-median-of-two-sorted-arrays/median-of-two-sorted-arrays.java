class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        int m=nums1.length;
        int n=nums2.length;
        int low=0;
        int high=m;
        while (low<=high){
            int i= (low+high)/2;
            int j=(m+n+1)/2-i;
            int left1=i==0?Integer.MIN_VALUE:nums1[i-1];
            int left2=j==0?Integer.MIN_VALUE:nums2[j-1];
            int right1=i==m?Integer.MAX_VALUE:nums1[i];
            int right2=j==n?Integer.MAX_VALUE:nums2[j];
            if (left1<=right2 && left2<=right1){
                if ((m+n)%2==0){
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }
                else{
                    return Math.max(left1,left2)*1.0;
                }
            }
            else if (right1<left2){
                low=i+1;
            }
            else{
                high=i-1;
            }
        }
        return -1.0;
    }
}