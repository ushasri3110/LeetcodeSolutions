class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy=-prices[0];
        int sell=0;
        for (int i=1;i<prices.length;i++)
        {
            int oldBuy=buy;
            buy=Math.max(buy,sell-prices[i]);
            sell=Math.max(sell,oldBuy+prices[i]-fee);
        }
        return Math.max(buy,sell);
    }
}