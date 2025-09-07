class Solution {
    public int[] sumZero(int n) {
        int[] ans=new int[n];
        for (int i=0;i<n/2;i++){
            ans[i]=i+1;
            ans[n-i-1]=-(i+1);
        }
        return ans;
    }
}