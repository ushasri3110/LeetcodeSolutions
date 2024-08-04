class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod=(int)1e9+7;
        List<Integer> subArraySum=new ArrayList<>();
        for (int i=0;i<n;i++){
            int sum=0;
            for (int j=i;j<n;j++){
                sum=sum+nums[j];
                subArraySum.add(sum);
            }
        }
        Collections.sort(subArraySum);
        int res=0;
        for (int i=left;i<=right;i++){
            res=(res+subArraySum.get(i-1))%mod;
        }
        return res;
    }
}