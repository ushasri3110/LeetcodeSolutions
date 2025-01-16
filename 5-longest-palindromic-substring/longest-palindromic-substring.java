class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String res="";
        for (int i=0;i<n;i++){
            String evenPalindrome=helper(i,i+1,s);
            String oddPalindrome=helper(i,i,s);
            String longest=evenPalindrome.length()>oddPalindrome.length()?evenPalindrome:oddPalindrome;
            if (longest.length()>res.length()){
                res=longest;
            }
        }
        return res;
    }
    public String helper(int start,int end,String s){
        int n=s.length();
        while (start>=0 && end<n && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}