class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[]=new boolean[rooms.size()];
        dfs(rooms,0,visited);
        for(boolean isVisited:visited){
            if (!isVisited){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms,int currentRoom,boolean[] visited){
        visited[currentRoom]=true;
        for (int key:rooms.get(currentRoom)){
            if (!visited[key]){
            dfs(rooms,key,visited);
            }
        }
    }
}