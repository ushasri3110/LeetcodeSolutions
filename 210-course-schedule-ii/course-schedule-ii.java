class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj=new List[numCourses];
        int[] indegree=new int[numCourses];
        int[] topo=new int[numCourses];
        for (int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for (int[] pre:prerequisites){
            adj[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<numCourses;i++){
            if (indegree[i]==0) q.offer(i);
        }
        int i=0;
        while (!q.isEmpty()){
            int node=q.poll();
            topo[i++]=node;
            for (int it:adj[node]){
                indegree[it]--;
                if (indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        return i==numCourses?topo:new int[]{};

    }
}