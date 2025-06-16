class Solution {
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        int[] set=new int[v];
        Arrays.fill(set,-1);
        for (int i=0;i<v;i++){
            if (set[i]==-1){
                if (!check(i,set,graph)) return false;
            }
        }
        return true;
    }
    private boolean check(int v,int[] set,int[][] graph){
        Queue<Integer> q=new LinkedList<>();
        q.offer(v);
        set[v]=0;
        while (!q.isEmpty()){
            int current=q.poll();
            for (int neighbor:graph[current]){
                if (set[neighbor]==-1){
                    set[neighbor]=1-set[current];
                    q.offer(neighbor);
                }
                else if (set[neighbor]==set[current]){
                    return false;
                }
            }
        }
        return true;
    }
}