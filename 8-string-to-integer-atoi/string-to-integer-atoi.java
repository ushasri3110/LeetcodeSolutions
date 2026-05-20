class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if (s.length()<1) return 0;
        int ans=0;
        int i=0;
        boolean isNegative=s.charAt(i)=='-';
        if (s.charAt(i)=='-' || s.charAt(i)=='+') i++;
        while (i<s.length()){
            char ch=s.charAt(i);
            if (!Character.isDigit(ch)){
                break;
            }
            int digit=ch-'0';
            if (ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10)){
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            ans=ans*10+digit;
            i++;
        }
        return isNegative?-ans:ans;
    }
}