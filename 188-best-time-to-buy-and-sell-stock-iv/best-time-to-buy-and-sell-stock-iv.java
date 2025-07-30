class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];
        for (int i=n-1;i>=0;i--){
            for (int buy=0;buy<=1;buy++){
                for (int tr=1;tr<=k;tr++){
                    int profit=0;
                    if (buy==0){
                        profit=Math.max(-prices[i]+dp[i+1][1][tr],dp[i+1][0][tr]);
                    }
                    else{
                        profit=Math.max(prices[i]+dp[i+1][0][tr-1],dp[i+1][1][tr]);
                    }
                    dp[i][buy][tr]=profit;
                }
            }
        }
        return dp[0][0][k];
    }
}