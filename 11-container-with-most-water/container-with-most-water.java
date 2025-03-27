class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        int i=0;
        int j=height.length-1;
        while (i<j){
            maxArea=Math.max(maxArea,Math.min(height[i],height[j])*Math.abs(j-i));
            if (height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxArea;
    }
}