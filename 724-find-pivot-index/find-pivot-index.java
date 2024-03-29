class Solution {
    public int pivotIndex(int[] nums) {
        int left[]=new int[nums.length];
        int right[]=new int[nums.length];
        left[0]=0;
        right[nums.length-1]=0;
        for (int i=1;i<nums.length;i++){
            left[i]=left[i-1]+nums[i-1];
        }
        for (int j=nums.length-2;j>=0;j--){
            right[j]=right[j+1]+nums[j+1];
        }
        for (int k=0;k<nums.length;k++){
            if (left[k]==right[k]){
                return k;
            }
        }
        return -1;
    }
}