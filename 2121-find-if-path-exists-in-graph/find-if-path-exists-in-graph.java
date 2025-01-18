class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int parent[]=new int[n];
        int rank[]=new int[n];
        for (int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for (int edge[]:edges){
            union(edge[0],edge[1],parent,rank);
        }

        return find(parent,source)==find(parent,destination);
    }
    public void union(int p,int q,int[] parent,int[] rank){
            int root1=find(parent,p);
            int root2=find(parent,q);
            if (root1!=root2){
                if (rank[root1]>rank[root2]){
                    parent[root2]=root1;
                }
                else if (rank[root2]>rank[root1]){
                    parent[root1]=root2;
                }
                else{
                    parent[root2]=root1;
                    rank[root1]++;
                }
            }
    }

    public int find(int[] parent,int node){
            if (parent[node]!=node){
                parent[node]=find(parent,parent[node]);
            }
            return parent[node];
        }
}