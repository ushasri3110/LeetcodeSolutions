class Solution {
    public int minimizeXor(int num1, int num2) {
        //count number of set bits in num2
        int c = Integer.bitCount(num2);
        
        int ans = 0;
        //set all bits of num1 from left to right until c> 0
        for(int i = 30;c>0 && i>=0 ;i--){
            c -= ( (num1>>i) & 1);
            ans |= (num1&(1<<i));
        }
        //if still c>0 fill the bits from left to right
        for(int i = 0;c>0 ;i++){
            if((ans&(1<<i)) == 0)  {
                ans |= 1<<i;
                c--;
            }
        }
        return ans;
    }
}