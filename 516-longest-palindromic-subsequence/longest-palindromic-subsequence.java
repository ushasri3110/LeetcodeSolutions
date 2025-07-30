class Solution {
    public int longestPalindromeSubseq(String s1) {
        StringBuilder sb=new StringBuilder(s1);
        String s2=sb.reverse().toString();
        int[] prev=new int[s2.length()+1];
        for (int i=1;i<=s1.length();i++){
            int[] current=new int[s1.length()+1];
            for (int j=1;j<=s2.length();j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    current[j]=1+prev[j-1];
                }
                else{
                    current[j]=Math.max(prev[j],current[j-1]);
                }
            }
            prev=current;
        }
        return prev[s2.length()];
    }
}