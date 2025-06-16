class Solution {
    private boolean isCycle(int v,List<Integer>[] adj,boolean[] visited,boolean[] path){
        visited[v]=true;
        path[v]=true;
        for (int node:adj[v]){
            if (!visited[node]){
                if (isCycle(node,adj,visited,path)) return true;;
            }
            else if (path[node]){
                return true;
            }
        }
        path[v]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj=new List[numCourses];
        for (int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for (int[] pre:prerequisites){
            adj[pre[0]].add(pre[1]);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] pathVisited=new boolean[numCourses];
        for (int i=0;i<numCourses;i++){
            if (!visited[i]){
                if (isCycle(i,adj,visited,pathVisited)) return false;
            }
        }
        return true;
    }
}