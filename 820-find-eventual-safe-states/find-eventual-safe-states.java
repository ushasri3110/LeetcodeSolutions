class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> topo=new ArrayList<>();
        int v=graph.length;
        int[] indegree=new int[v];
        List<Integer>[] adj=new List[v];
        for (int i=0;i<v;i++){
            adj[i]=new ArrayList<>();
        }
        for (int i=0;i<v;i++){
            for (int j:graph[i]){
                adj[j].add(i);
            }
        }
        for (int i=0;i<v;i++){
            for (int j:adj[i]){
                indegree[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<v;i++){
            if (indegree[i]==0) q.offer(i);
        }
        while (!q.isEmpty()){
            int node=q.poll();
            topo.add(node);
            for (int it:adj[node]){
                indegree[it]--;
                if (indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        Collections.sort(topo);
        return topo;
    }
}