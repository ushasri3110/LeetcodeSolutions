class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea=0;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[] height=new int[cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (matrix[i][j]=='1') height[j]+=1;
                else height[j]=0;
            }
            maxArea=Math.max(maxArea,findArea(height));
        }
        return maxArea;
    }
    public int findArea(int[] height){
        int area=0;
        for (int i=0;i<height.length;i++){
            int minHeight=Integer.MAX_VALUE;
            for (int j=i;j<height.length;j++){
                minHeight=Math.min(height[j],minHeight);
                area=Math.max(area,minHeight*(j-i+1));
            }
        }
        return area;
    }

}