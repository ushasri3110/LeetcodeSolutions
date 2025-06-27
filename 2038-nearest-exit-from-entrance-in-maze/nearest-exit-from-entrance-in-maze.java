class Solution {
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;
        maze[entrance[0]][entrance[1]]='+';
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{entrance[0],entrance[1],0});
        while (!q.isEmpty()){
            int[] current=q.poll();
            int crow=current[0];
            int ccol=current[1];
            int steps=current[2];
            for(int[] dir:directions){
                int newRow=dir[0]+crow;
                int newCol=dir[1]+ccol;
                if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && maze[newRow][newCol]=='.'){
                    if (newRow==0 || newCol==0 || newRow==m-1 || newCol==n-1) return steps+1;
                    maze[newRow][newCol]='+';
                    q.offer(new int[]{newRow,newCol,steps+1});
                }
            }
        }
        return -1;
    }
}