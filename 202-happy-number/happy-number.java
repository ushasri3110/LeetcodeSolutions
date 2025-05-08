class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while (true){
            int sum=0;
            while (n!=0){
                int rem=n%10;
                sum+=Math.pow(rem,2);
                n=n/10;
            }
            if (sum==1) return true;
            n=sum;
            if (set.contains(n)) return false;
            set.add(n);
        }
    }
}