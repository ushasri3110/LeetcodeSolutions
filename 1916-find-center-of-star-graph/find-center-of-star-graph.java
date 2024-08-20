class Solution {
    public int findCenter(int[][] edges) {
        int nodes=edges.length+1;
        int indegree[]=new int[nodes];
        int outdegree[]=new int[nodes];
        for (int i=0;i<edges.length;i++){
            outdegree[edges[i][0]-1]+=1;
            indegree[edges[i][1]-1]+=1;
        }
        for (int j=0;j<nodes;j++){
            if (outdegree[j]+indegree[j]==nodes-1){
                return j+1;
            }
        }
        return -1;
    }
}