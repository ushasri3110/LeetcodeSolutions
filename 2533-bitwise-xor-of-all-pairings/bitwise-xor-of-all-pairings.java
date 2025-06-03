class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int xor1=0;
        int xor2=0;
        int res=0;
        for (int i:nums1){
            xor1^=i;
        }
        for (int j:nums2){
            xor2^=j;
        }
        if (m%2!=0 && n%2!=0) res=xor1^xor2;
        else if (m%2==0 && n%2!=0) res=xor1;
        else if (n%2==0 && m%2!=0) res=xor2;
        return res;
    }
}