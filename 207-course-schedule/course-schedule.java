class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj=new List[numCourses];
        for (int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for (int[] pre:prerequisites){
            adj[pre[0]].add(pre[1]);
        }
        int[] indegree=new int[numCourses];
        for (int i=0;i<numCourses;i++){
            for (int it:adj[i]){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<numCourses;i++){
            if (indegree[i]==0) q.add(i);
        }
        int count=0;
        while (!q.isEmpty()){
            int node=q.poll();
            count++;
            for (int i:adj[node]){
                indegree[i]--;
                if (indegree[i]==0) q.add(i);
            }
        }
        return count==numCourses;
    }
}