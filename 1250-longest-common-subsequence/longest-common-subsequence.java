class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for (int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
    public int helper(int i,int j,String text1,String text2,int[][] dp){
        if (i<0 || j<0) return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        if (text1.charAt(i)==text2.charAt(j)) return 1+helper(i-1,j-1,text1,text2,dp);
        return dp[i][j]=Math.max(helper(i-1,j,text1,text2,dp),helper(i,j-1,text1,text2,dp));
    }
}