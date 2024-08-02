class Solution {
    public String longestPalindrome(String s) {
        String res="";
        for (int i=0;i<s.length();i++){
            String evenPalindrome=palindrome(s,i-1,i);
            String oddPalindrome=palindrome(s,i,i);
            String longest="";
            if (evenPalindrome.length()>oddPalindrome.length()){
                longest=evenPalindrome;
            }
            else
            {
                longest=oddPalindrome;
            }
            if (res.length()<longest.length()){
                res=longest;
            }
        }
        return res;
    }
    public String palindrome(String s,int left,int right){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}