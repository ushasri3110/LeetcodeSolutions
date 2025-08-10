class Solution {
    public int myAtoi(String s) {
        int res=0;
        int n=s.length();
        int i=0;
        s=s.trim();
        if (s.length()<1) return 0;
        boolean isNegative=s.charAt(0)=='-';
        if (s.charAt(0)=='-' || s.charAt(0)=='+'){
            i++;
        }
        while (i<s.length()){
            char ch=s.charAt(i);
            if (!Character.isDigit(ch)){
                break;
            }
            int digit=ch-'0';
            if (res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10)){
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            res=res*10+digit;
            i++;
        }
        return isNegative?-res:res;
    }
}