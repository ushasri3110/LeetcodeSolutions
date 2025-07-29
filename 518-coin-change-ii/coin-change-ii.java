class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i=coins[0];i<=amount;i++){
            if (i%coins[0]==0) dp[i]=1;
        }
        for (int i=1;i<coins.length;i++){
            int[] temp=new int[amount+1];
            temp[0]=1;
            for (int j=1;j<=amount;j++){
                int notPick=dp[j];
                int pick=0;
                if (coins[i]<=j){
                    pick=temp[j-coins[i]];
                }
                temp[j]=pick+notPick;
            }
            dp=temp;
        }
        return dp[amount];
    }
}