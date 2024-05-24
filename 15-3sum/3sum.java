class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                if (nums[i]+nums[j]+nums[k]==0){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if (nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}