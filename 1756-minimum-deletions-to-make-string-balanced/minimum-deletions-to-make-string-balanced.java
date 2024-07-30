class Solution {
    public int minimumDeletions(String s) {
        int ans=0;
        int b=0;
        for (char c:s.toCharArray()){
            if (c=='b'){
                b++;
            }
            else{
                ans=Math.min(ans+1,b);
            }
        }
        return ans;
    }
}