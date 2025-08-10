class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxArea=Integer.MIN_VALUE;
        while (i<=j){
            int currentArea= Math.min(height[i],height[j])*Math.abs(j-i);
            maxArea=Math.max(maxArea,currentArea);
            if (height[i]>height[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return maxArea;
    }
}