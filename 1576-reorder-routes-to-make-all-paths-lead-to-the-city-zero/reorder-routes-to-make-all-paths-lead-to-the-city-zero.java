class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph=new ArrayList<>();
        for (int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] c:connections){
            int from=c[0];
            int to=c[1];
            graph.get(from).add(new int[]{to,1});
            graph.get(to).add(new int[]{from,0});
        }
        boolean visited[]=new boolean[n];
        return dfs(graph,visited,0);
    }
    public int dfs(List<List<int[]>> graph,boolean[] visited,int current){
        visited[current]=true;
        int count=0;
        for(int[] neighbour:graph.get(current)){
            int nextCity=neighbour[0];
            int direction=neighbour[1];
            if (!visited[nextCity]){
                count+=direction;
                count+=dfs(graph,visited,nextCity);
            }
        }
        return count;
    }
}