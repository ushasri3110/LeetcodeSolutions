class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj=new int[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i!=j) adj[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int[] edge:edges){
            adj[edge[0]][edge[1]]=edge[2];
            adj[edge[1]][edge[0]]=edge[2];
        }
        for (int via=0;via<n;via++){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (adj[i][via]<Integer.MAX_VALUE && adj[via][j]<Integer.MAX_VALUE){
                        adj[i][j]=Math.min(adj[i][j],adj[i][via]+adj[via][j]);
                    }
                }
            }
        }
        int city=-1;
        int minCount=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int c=0;
            for (int j=0;j<n;j++){
                if (i!=j && adj[i][j]<=distanceThreshold){
                    c++;
                }
            }
            if (c<=minCount){
                minCount=c;
                city=i;
            }
        }
        return city;
    }
}