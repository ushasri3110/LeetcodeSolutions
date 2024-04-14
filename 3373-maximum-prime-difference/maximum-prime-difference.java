class Solution {
    public boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    public int maximumPrimeDifference(int[] nums) {
        int i=0;
        int j=nums.length-1;
        for (int k=0;k<nums.length;k++){
            if (!isPrime(nums[i])){
                i++;
            }
            if (!isPrime(nums[j])){
                j--;
            }
            if (isPrime(nums[i]) && isPrime(nums[j])) {
                break;
            }
        }
        return Math.abs(i-j);
    }
}