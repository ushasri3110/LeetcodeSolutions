class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        permuteUniqueHelper(result,new ArrayList<>(),nums,new boolean[nums.length]);
        return result;
    }
    public void permuteUniqueHelper(List<List<Integer>> result,List<Integer> current,int[] nums,boolean[] visited){
        if (current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i - 1])) continue;
            current.add(nums[i]);
            visited[i]=true;
            permuteUniqueHelper(result,current,nums,visited);
            current.remove(current.size()-1);
            visited[i]=false;
        }
    }
}