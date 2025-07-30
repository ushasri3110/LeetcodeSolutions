class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[] dp=new int[2];
        for (int i=n-1;i>=0;i--){
            int[] temp=new int[2];
            for (int buy=0;buy<=1;buy++){
                int profit=0;
                if (buy==0){
                    profit=Math.max(-prices[i]+dp[1],dp[0]);
                }
                else{
                    profit=Math.max(prices[i]-fee+dp[0],dp[1]);
                }
                temp[buy]=profit;
            }
            dp=temp;
        }
        return dp[0];
    }
}