class Solution {
    public int equalPairs(int[][] grid) {
        int count=0;
        Map<String,Integer> rowMap=new HashMap<>();
        for (int[] row:grid){
            String r=Arrays.toString(row);
            rowMap.put(r,rowMap.getOrDefault(r,0)+1);
        }
        for (int i=0;i<grid.length;i++){
            int colArray[]=new int[grid.length];
            for(int j=0;j<grid.length;j++){
                colArray[j]=grid[j][i];
            }
            String c=Arrays.toString(colArray);
            count=count+rowMap.getOrDefault(c,0);
        }
        return count;
    }
}