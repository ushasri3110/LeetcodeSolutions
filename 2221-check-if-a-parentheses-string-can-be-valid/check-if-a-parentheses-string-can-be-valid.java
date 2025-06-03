class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if (n%2!=0) return false;
        int close=0,open=0,wildCard=0;
        for (int i=0;i<n;i++){
            if (locked.charAt(i)=='0') wildCard++;
            else if (s.charAt(i)=='(') open++;
            else close++;
            if (wildCard+open<close) return false;
        }
        open=close=wildCard=0;
        for (int i=n-1;i>=0;i--){
            if (locked.charAt(i)=='0') wildCard++;
            else if (s.charAt(i)=='(') open++;
            else close++;
            if (wildCard+close<open) return false;
        }
        return true;
    }
}