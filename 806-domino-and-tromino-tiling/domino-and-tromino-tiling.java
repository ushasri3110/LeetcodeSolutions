class Solution {
    public int numTilings(int n) {
        int mod=1000000007;
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=2;
        dp[2]=5;
        for (int i=3;i<n;i++){
            dp[i]=((dp[i-1]*2)%mod+(dp[i-3]%mod))%mod;
        }
        return dp[n-1]%mod;
    }
}