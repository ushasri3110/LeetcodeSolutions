class Solution {
    public int findCenter(int[][] edges) {
        int nodes=edges.length+1;
        int degree[]=new int[nodes];
        for (int[] row:edges){
            degree[row[0]-1]++;
            degree[row[1]-1]++;
        }
        for (int i=0;i<nodes;i++){
            if (degree[i]==nodes-1){
                return i+1;
            }
        }
        return -1;
    }
}