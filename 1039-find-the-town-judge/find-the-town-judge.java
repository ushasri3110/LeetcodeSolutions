class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree=new int[n];
        int[] outdegree=new int[n];

        for (int[] row:trust){
            outdegree[row[0]-1]++;
            indegree[row[1]-1]++;
        }

        for (int i=0;i<n;i++){
            if (outdegree[i]==0 && indegree[i]==n-1){
                return i+1;
            }
        }

        return -1;
        
    }
}