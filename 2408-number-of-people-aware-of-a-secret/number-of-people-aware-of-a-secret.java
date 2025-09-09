class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int day = 2; day <= n; day++) {
            for (int j = day - forget + 1; j <= day - delay; j++) {
                if (j >= 1) {
                    dp[day] = (dp[day] + dp[j]) % MOD;
                }
            }
        }
        long ans = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                ans = (ans + dp[day]) % MOD;
            }
        }

        return (int) ans;
    }
}