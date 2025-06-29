class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int low = 0, high = n- 1;

        while (low <= high) {
            int mid=(low+high)/2;
            boolean leftEqual= mid>0 && nums[mid]==nums[mid-1];
            boolean rightEqual=mid<n-1 && nums[mid]==nums[mid+1];
            if (!leftEqual && !rightEqual) return nums[mid];
            if (leftEqual){
                int leftCount=mid-1+low+1;
                if (leftCount%2==0){
                    high=mid-2;
                }
                else{
                    low=mid+1;
                }
            }
            else if(rightEqual){
                int rightCount=high+1-(mid+1);
                if (rightCount%2==0){
                    low=mid+2;
                }
                else{
                    high=mid-1;
                }
            }
        }

        return -1;
    }
}
