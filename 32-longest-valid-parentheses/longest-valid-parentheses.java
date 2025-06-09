class Solution {
    public int longestValidParentheses(String s) {
        int open=0;
        int close=0;
        int maxLength=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                open++;
            }
            else{
                close++;
            }
            if (open==close){
                int len=open+close;
                maxLength=Math.max(len,maxLength);
            }
            else if (open<close){
                open=0;
                close=0;
            }
        }
        open=close=0;
        for (int i=s.length()-1;i>0;i--){
            if (s.charAt(i)=='('){
                open++;
            }
            else{
                close++;
            }
            if (open==close){
                int len=open+close;
                maxLength=Math.max(len,maxLength);
            }
            else if (open>close){
                open=0;
                close=0;
            }
        }
        return maxLength;
    }
}