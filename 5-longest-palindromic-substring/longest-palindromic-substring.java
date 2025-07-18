class Solution {
    public String longestPalindrome(String s) {
        int i=0;
        int longest=0;
        int startIndex=0;
        while(i<s.length()){
            int oddLength=palindromeHelper(i,i,s);
            int evenLength=palindromeHelper(i,i+1,s);
            int currentLength=Math.max(oddLength,evenLength);
            if (currentLength>longest){
                longest=currentLength;
                startIndex=i-(currentLength-1)/2;
            }
            i++;
        }
        return s.substring(startIndex,startIndex+longest);
    }
    public int palindromeHelper(int start,int end,String str){
        while (start>=0 && end<str.length() && str.charAt(start)==str.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
    
}