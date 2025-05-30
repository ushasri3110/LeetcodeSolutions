class Solution {
    public int maxProfit(int[] prices) {
        int min_price=Integer.MAX_VALUE;
        int profit=0;
        for (int i:prices){
            if (i<min_price){
                min_price=i;
            }
            else{
                profit=Math.max(profit,i-min_price);
            }
        }
        return profit;
    }
}