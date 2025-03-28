class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        int n=nums.length;
        for (int i=0;i<n-3;i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            for (int j=i+1;j<n-2;j++){
                if (j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum= (long) nums[i]+nums[j]+nums[k]+nums[l];
                    if (sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while (k<l && nums[k]==nums[k+1]) k++;
                        while (k<l && nums[l]==nums[l-1]) l--;
                        k++;
                        l--;
                    }
                    else if (sum<target) k++;
                    else l--;
                }
            }
        }
        return result;
    }
}