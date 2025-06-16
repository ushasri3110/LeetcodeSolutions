class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inc=image[sr][sc];
        dfs(sr,sc,inc,color,image);
        return image;
    }
    private void dfs(int sr,int sc,int inc,int color,int[][] image){
        if (sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]==color || image[sr][sc]!=inc) return;
        image[sr][sc]=color;
        dfs(sr-1,sc,inc,color,image);
        dfs(sr+1,sc,inc,color,image);
        dfs(sr,sc-1,inc,color,image);
        dfs(sr,sc+1,inc,color,image);
    }
}