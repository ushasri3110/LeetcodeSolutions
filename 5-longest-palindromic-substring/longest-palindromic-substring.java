class Solution {
    public String longestPalindrome(String s) {
        String result="";
        for (int i=0;i<s.length();i++){
            String evenPalindrome=palindromeHelper(i,i+1,s);
            String oddPalindrome=palindromeHelper(i,i,s);
            String longest=evenPalindrome.length()>oddPalindrome.length()?evenPalindrome:oddPalindrome;
            if (longest.length()>result.length()){
                result=longest;
            }
        }
        return result;
    }
    public String palindromeHelper(int start,int end,String s){
        int n=s.length();
        while (start>=0 && end<n && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}