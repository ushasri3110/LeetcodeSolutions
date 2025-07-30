class Solution {
    public int minDistance(String s1, String s2) {
        int n=s2.length();
        int m=s1.length();
         int[] prev=new int[n+1];
        for (int i=1;i<=m;i++){
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
        int longest=prev[n];
        return m+n-(2*longest);
    }
}