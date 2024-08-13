class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,new ArrayList<Integer>(),target,0);
        return result;
    }
    public void helper(int[] candidates,ArrayList<Integer> temp,int rem,int index){
        if (rem<0){
            return;
        }
        else if (rem==0){
            if (!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
        }
        else{
           for(int i=index;i<candidates.length && candidates[i]<=rem;i++){
            if (i > index && candidates[i] == candidates[i - 1]) {
                    continue; // Skip duplicates
                }
            temp.add(candidates[i]);
            helper(candidates,temp,rem-candidates[i],i+1);
            temp.remove(temp.size()-1);
           }
        }
    }
}