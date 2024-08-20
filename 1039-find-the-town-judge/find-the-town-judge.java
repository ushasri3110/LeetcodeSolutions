class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree=new int[n];
        int[] outdegree=new int[n];
        for(int i=0;i<trust.length;i++){
            outdegree[trust[i][0]-1]+=1;
            indegree[trust[i][1]-1]+=1;
        }
        for (int j=0;j<n;j++){
            if (outdegree[j]==0 && indegree[j]==n-1){
                return j+1;
            }
        }
        return -1;
    }
}