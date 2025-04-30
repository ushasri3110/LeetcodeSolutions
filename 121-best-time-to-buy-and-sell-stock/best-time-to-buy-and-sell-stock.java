class Solution {
    public int maxProfit(int[] prices) {
        int current_profit=0;
        int buy_price=prices[0];
        int max_profit=0;
        for (int i=1;i<prices.length;i++){
            if (buy_price<prices[i]){
                current_profit=prices[i]-buy_price;
                max_profit=Math.max(max_profit,current_profit);
            }
            else{
                buy_price=prices[i];
            }
        }
        return max_profit;
    }
}