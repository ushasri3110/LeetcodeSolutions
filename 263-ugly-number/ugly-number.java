class Solution {
    public boolean isUgly(int n) {
        if (n==0){
            return false;
        }
        while (true){
            if (n%2!=0){
                break;
            }
            n=n/2;
        }
        while (true){
            if (n%3!=0){
                break;
            }
            n=n/3;
        }
        while (true){
            if (n%5!=0){
                break;
            }
            n=n/5;
        }
        return n==1;
    }
}