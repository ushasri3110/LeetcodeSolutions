class Solution {
    public int myAtoi(String s) {
        int res=0;
        s=s.trim();
        if (s.length()==0){
            return 0;
        }
        int i=0;
        boolean isNegative=s.charAt(0)=='-';
        if (s.charAt(i)=='+'||s.charAt(i)=='-'){
            i++;
        }
        while (i<s.length()){
            char current=s.charAt(i);
            if (Character.isDigit(current)){
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && current - '0' > Integer.MAX_VALUE % 10)) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res=res*10+(current-'0');
            }
            else{
                break;
            }
            i++;
        }
        return isNegative?res*-1:res;
    }
}