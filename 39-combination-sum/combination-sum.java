class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumHelper(0, new ArrayList<>(), candidates, target);
        return res;
    }

    public void combinationSumHelper(int index, List<Integer> current, int[] candidates, int target) {
        if (index == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(current));
            }
            return;
        }
        if (candidates[index] <= target) {
            current.add(candidates[index]);
            combinationSumHelper(index, current, candidates, target - candidates[index]);
            current.remove(current.size() - 1);
        }
        combinationSumHelper(index + 1, current, candidates, target);
    }
}