class Solution {
    public String longestPalindrome(String s) {
        int maxLength=0;
        int startIndex=-1;
        for (int i=0;i<s.length();i++){
            int odd=palindromeChecker(i,i,s);
            int even=palindromeChecker(i,i+1,s);
            int currentLength=Math.max(odd,even);
            if (currentLength>maxLength){
                maxLength=currentLength;
                startIndex=i-(maxLength-1)/2;
            }
        }
        return s.substring(startIndex,startIndex+maxLength);
    }
    private int palindromeChecker(int start,int end,String s){
        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
}