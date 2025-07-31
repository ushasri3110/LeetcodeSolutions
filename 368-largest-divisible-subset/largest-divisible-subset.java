class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n];
        int[] parent=new int[n];
        Arrays.fill(dp,1);
        for (int i=1;i<n;i++){
            parent[i]=i;
            for (int prev=0;prev<i;prev++){
                if ((nums[prev]%nums[i]==0 || nums[i]%nums[prev]==0) && dp[i]<dp[prev]+1){
                    dp[i]=dp[prev]+1;
                    parent[i]=prev;
                }
            }
        }
        int longest=-1;
        int lastIndex=-1;
        for (int i=0;i<n;i++){
            System.out.print(dp[i]+" ");
            if (dp[i]>longest){
                longest=dp[i];
                lastIndex=i;
            }
        }
        List<Integer> res=new ArrayList<>();
        res.add(nums[lastIndex]);
        while (parent[lastIndex]!=lastIndex){
            lastIndex=parent[lastIndex];
            res.add(nums[lastIndex]);
        }
        Collections.reverse(res);
        return res;
    }
}