class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] prev=new int[text2.length()+1];
        for (int i=1;i<=text1.length();i++){
            int[] curr=new int[text2.length()+1];
            for (int j=1;j<=text2.length();j++){
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    curr[j]=prev[j-1]+1;
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev=curr;
        }
        return prev[text2.length()];
    }
}