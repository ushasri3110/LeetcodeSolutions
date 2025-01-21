class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            // while (i>0 && nums[i-1] == nums[i]) {
            //     i++;
            //     continue;
            // }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // while (j>0 && nums[j-1] == nums[j]) {
                //     j++;
                //     continue;
                // }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long currentSum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                    if (currentSum == (long) target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (currentSum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}