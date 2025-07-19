class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height=triangle.size();
        int[] dp=new int[height+1];
        for (int i=height-1;i>=0;i--){
            for (int j=0;j<=i;j++){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}