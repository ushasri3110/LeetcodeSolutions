class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int i=1;i<=60;i++){
            long x= (long)num1- (long) i*num2;
            if (x<0) continue;
             if (Long.bitCount(x) <= i && x >= i) {
                return i;
            }
        }
        return -1;
    }
}