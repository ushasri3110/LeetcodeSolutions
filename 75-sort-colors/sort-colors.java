class Solution {
    public void sortColors(int[] nums) {
        int zeroCount=0;
        int oneCount=0;
        int twoCount=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                zeroCount++;
            }
            else if (nums[i]==1){
                oneCount++;
            }
            else{
                twoCount++;
            }
        }
        int j=0;
        for (int i=0;i<zeroCount;i++){
            nums[j]=0;
            j++;
        }
        for (int i=0;i<oneCount;i++){
            nums[j]=1;
            j++;
        }
        for (int i=0;i<twoCount;i++){
            nums[j]=2;
            j++;
        }
    }
}