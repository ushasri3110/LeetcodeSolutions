class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        res[0]=0;
        int prevPower=0;
        for (int i=1;i<=n;i++){
            if ((i & (i-1)) == 0){
                res[i]=1;
                prevPower=i;
            }
            else{
                res[i]=1+res[i-prevPower];
            }
        }
        return res;

    }
}