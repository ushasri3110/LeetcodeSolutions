class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] adj=new List[n];
        for (int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for (int[] con:connections){
            adj[con[0]].add(new int[]{con[1],1});
            adj[con[1]].add(new int[]{con[0],0});
        }
        return dfs(adj,new boolean[n],0);
    }
    private int dfs(List<int[]>[] adj,boolean[] visited,int from){
        int count=0;
        visited[from]=true;
        for (int[] i:adj[from]){
            int next=i[0];
            int c=i[1];
            if (!visited[next]){
                count+=c+dfs(adj,visited,next);
            }
        }
        return count;
    }
}