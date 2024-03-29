class Solution {
    public int equalPairs(int[][] grid) {
        int count=0;
        Map<String,Integer> rowMap=new HashMap<>();
        for (int[] row:grid){
            String rowString=Arrays.toString(row);
            rowMap.put(rowString,rowMap.getOrDefault(rowString,0)+1);
        }
        for (int i=0;i<grid.length;i++){
            int colArray[]=new int[grid.length];
                for (int j=0;j<grid.length;j++){
                    colArray[j]=grid[j][i];
                }
                count+=rowMap.getOrDefault(Arrays.toString(colArray),0);
        }
        return count;
    }
}