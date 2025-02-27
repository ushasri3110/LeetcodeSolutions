class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        int n=nums.length;
        Arrays.sort(nums);
        for (int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while (j<k){
                int currentSum=nums[i]+nums[j]+nums[k];
                if (currentSum==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if (currentSum>0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}