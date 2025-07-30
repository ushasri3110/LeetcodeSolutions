class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;
        for (int i=n-1;i>=0;i--){
            for (int buy=0;buy<=1;buy++){
                int profit=0;
                if (buy==0){
                    profit=Math.max(-prices[i]+dp[i+1][1],dp[i+1][0]);
                }
                else{
                    profit=Math.max(prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                dp[i][buy]=profit;
            }
        }
        return dp[0][0];
    }
    public int profitHelper(int i,boolean buy,int[] prices){
        if (i==prices.length) return 0;
        int profit=0;
        if (buy){
            profit=Math.max(-prices[i]+profitHelper(i+1,false,prices),0+profitHelper(i+1,true,prices));
        } 
        else{
            profit=Math.max(prices[i]+profitHelper(i+1,true,prices),profitHelper(i+1,false,prices));
        }
        return profit;
    }
}