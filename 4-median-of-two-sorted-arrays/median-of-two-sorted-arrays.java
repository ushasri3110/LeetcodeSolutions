class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int nums3[]=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while (i<n && j<m){
            if (nums1[i]<=nums2[j]){
                nums3[k++]=nums1[i++];
            }
            else if (nums1[i]>nums2[j]){
                nums3[k++]=nums2[j++];
            }
        }
        while (i<n){
            nums3[k++]=nums1[i++];
        }
        while (j<m){
            nums3[k++]=nums2[j++];
        }
        int mid=(int)(m+n)/2;
        System.out.println(mid);
        return (m+n)%2==0?(nums3[mid]+nums3[mid-1])/2.0:nums3[mid]/1.0;
    }
}