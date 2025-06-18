class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int rows=n/3;
        Arrays.sort(nums);
        int[][] res=new int[rows][3];
        int j=0;
        for (int i=2;i<n;i+=3){
            if (nums[i]-nums[i-2]>k) return new int[][]{};
            res[j][0]=nums[i-2];
            res[j][1]=nums[i-1];
            res[j][2]=nums[i];
            j++;
        }
        return res;
    }
}