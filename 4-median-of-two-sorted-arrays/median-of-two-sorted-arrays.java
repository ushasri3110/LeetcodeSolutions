class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            int maxX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = partitionX == m ? Integer.MAX_VALUE : nums1[partitionX];
            int maxY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = partitionY == n ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    median = (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                    return median;
                } else {
                    median = Math.max(maxX, maxY);
                    return median;
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return median;
    }
}