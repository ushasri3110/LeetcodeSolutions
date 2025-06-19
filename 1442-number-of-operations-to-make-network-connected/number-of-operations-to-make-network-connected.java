class Solution {
    private int findParent(int node,int[] parent){
        if (parent[node]!=node){
            parent[node]=findParent(parent[node],parent);
        }
        return parent[node];
    }
    private void union(int u,int v,int[] rank,int[] parent){
        if (rank[u]>rank[v]){
            parent[v]=u;
        }
        else if (rank[v]>rank[u]){
            parent[u]=v;
        }
        else{
            parent[v]=u;
            rank[u]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if (connections.length<n-1) return -1;
        int[] parent=new int[n];
        int[] rank=new int[n];
        for (int i=0;i<n;i++){
            parent[i]=i;
        }
        int components=n;
        for (int[] edge:connections){
            int pu=findParent(edge[0],parent);
            int pv=findParent(edge[1],parent);
            if (pu!=pv){
                union(pu,pv,rank,parent);
                components--;
            }
        }
        return components-1;
    }
}