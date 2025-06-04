class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBits=countSetBits(num2);
        int res=0;
        for (int i=31;i>=0 && setBits>0;i--){
            if ((num1 & (1<<i))!=0){
                setBits--;
                res+=(1<<i);
            }
        }
        for (int i=0;i<32 && setBits>0;i++){
            if ((num1 & (1<<i))==0){
                setBits--;
                res+=(1<<i);
            }
        }
        return res;

    }
    private int countSetBits(int num){
        int count=0;
        while (num>0){
            count+= (num & 1);
            num = num>>1;
        }
        return count;
    }
}