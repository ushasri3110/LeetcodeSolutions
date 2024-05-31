class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if (s.length()<=0){
            return 0;
        }
        int index=0;
        int num=0;
        boolean isNegative=false;
        if (s.charAt(0)=='-'||s.charAt(0)=='+'){
            isNegative=s.charAt(0)=='-';
            index++;
        }
        while (index<s.length()){
            char c=s.charAt(index);
            if (c<'0'||c>'9'){
                break;
            }
            int digit=c-'0';
             if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num=num*10+digit;
            index++;
            
        }
        return isNegative?num*-1:num;
    }
}