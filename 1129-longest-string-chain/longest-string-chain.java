class Solution {
    public boolean isPredecessor(String s1,String s2){
        if (s1.length() + 1 != s2.length()) return false;
        int i=0;
        int j=0;
        while (i<s1.length() && j<s2.length()){
            if (s1.charAt(i)==s2.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s1.length();
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,Comparator.comparingInt(String::length));
        int n=words.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for (int i=0;i<n;i++){
            for (int prev=0;prev<i;prev++){
                if (isPredecessor(words[prev],words[i]) && dp[prev]+1 > dp[i]){
                    dp[i]=dp[prev]+1;
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
}