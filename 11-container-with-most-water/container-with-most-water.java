class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            max_area = Math.max(Math.min(height[i], height[j]) * Math.abs(i - j), max_area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max_area;
    }
}
