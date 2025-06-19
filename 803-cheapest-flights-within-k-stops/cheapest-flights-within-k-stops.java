class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<int[]>[] adj=new List[n];
        for (int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for (int[] flight:flights){
            adj[flight[0]].add(new int[]{flight[1],flight[2]});
        }
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,0,0});
        while (!q.isEmpty()){
            int[] current=q.poll();
            int steps=current[2];
            int city=current[0];
            int cost=current[1];
            if (steps>k) continue;
            for (int[] next:adj[city]){
                int nextCity=next[0];
                int price=next[1];
                if (price+cost<dist[nextCity]&& steps<=k){
                    dist[nextCity]=price+cost;
                    q.offer(new int[]{nextCity,cost+price,steps+1});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}