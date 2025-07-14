class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getCount(nums,k)-getCount(nums,k-1);
    }
    public int getCount(int[] nums,int k){
        if (k<0) return 0;
        int start=0;
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int end=0;end<nums.length;end++){
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            while (map.size()>k){
                map.put(nums[start],map.get(nums[start])-1);
                if (map.get(nums[start])==0) map.remove(nums[start]);
                start++;
            }
            if (map.size()<=k) count=count+(end-start+1);
        }
        return count;
    }
}