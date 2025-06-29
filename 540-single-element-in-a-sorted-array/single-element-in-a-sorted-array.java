class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean leftEqual = mid > 0 && nums[mid] == nums[mid - 1];
            boolean rightEqual = mid < nums.length - 1 && nums[mid] == nums[mid + 1];

            if (!leftEqual && !rightEqual) {
                return nums[mid]; // Found the single element
            }

            // Determine the correct half to search
            if (leftEqual) {
                int leftCount = mid - 1 - low + 1;
                if (leftCount % 2 != 0) {
                    low = mid + 1;
                } else {
                    high = mid - 2;
                }
            } else if (rightEqual) {
                int rightCount = high - (mid + 1) + 1;
                if (rightCount % 2 != 0) {
                    high = mid - 1;
                } else {
                    low = mid + 2;
                }
            }
        }

        return -1; // Should never reach here if input is valid
    }
}
