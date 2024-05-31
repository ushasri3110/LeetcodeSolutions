class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign=(dividend >= 0) == (divisor >= 0);
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        int result=0;
        while (a-b>=0){
            int count=0;
            while (a-(b<<count+1)>=0){
                count++;
            }
            result+=1<<count;
            a=a-(b<<count);
        }
        return sign?result:-1*result;
    }
}