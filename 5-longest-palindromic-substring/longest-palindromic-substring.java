class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=0){
            return null;
        }
        String longestPalindrome="";
        for(int i=0;i<s.length();i++){
            String oddPalindrome=longestPalindromeHelper(s,i,i);
            if(oddPalindrome.length()>longestPalindrome.length()){
                longestPalindrome=oddPalindrome;
            }
            String evenPalindrome=longestPalindromeHelper(s,i-1,i);
            if (evenPalindrome.length()>longestPalindrome.length()){
                longestPalindrome=evenPalindrome;
            }
        }
        return longestPalindrome;
    }
    public String longestPalindromeHelper(String s,int start,int end){
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}