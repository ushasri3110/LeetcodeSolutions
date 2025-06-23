class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(0,n-k,nums);
        reverse(n-k,n,nums);
        reverse(0,n,nums);
    }
    private void reverse(int start,int end,int[] nums){
        end=end-1;
        while (start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}