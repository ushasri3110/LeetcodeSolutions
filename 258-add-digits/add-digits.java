class Solution {
    public int addDigits(int num) {
        int res=num;
        while (res>9){
            int val=0;
            int rem;
            while (res!=0){
                rem=res%10;
                val+=rem;
                res=res/10;
            }
            res=val;
        }
        return res;
    }
}