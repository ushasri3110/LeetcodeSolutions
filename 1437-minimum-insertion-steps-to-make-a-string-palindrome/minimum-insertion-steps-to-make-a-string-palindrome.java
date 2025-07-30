class Solution {
    public int minInsertions(String s1) {
        int n=s1.length();
        StringBuilder sb=new StringBuilder(s1);
        String s2=sb.reverse().toString();
        int[] prev=new int[n+1];
        for (int i=1;i<=n;i++){
            int[] current=new int[n+1];
            for (int j=1;j<=n;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    current[j]=prev[j-1]+1;
                }
                else{
                    current[j]=Math.max(prev[j],current[j-1]);
                }
            }
            prev=current;
        }
        return n-prev[n];
    }
}