class Solution {
    public boolean isHappy(int n) {
        int hare=n;
        int tortoise=n;
        do{
            tortoise=square(tortoise);
            hare=square(square(hare));
        }
        while (tortoise!=hare);
        return tortoise==1;
    }
    public int square(int n){
        int ans=0;
        while (n>0){
            int rem=n%10;
            ans+=rem*rem;
            n=n/10;
        }
        return ans;
    }
}