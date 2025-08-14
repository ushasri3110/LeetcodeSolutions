class Pair{
    int vertex;
    int time;
    Pair(int vertex,int time){
        this.vertex=vertex;
        this.time=time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] t:times){
            adj.get(t[0]-1).add(new Pair(t[1]-1,t[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        int[] minTime=new int[n];
        Arrays.fill(minTime,Integer.MAX_VALUE);
        minTime[k-1]=0;
        pq.offer(new Pair(k-1,0));
        while (!pq.isEmpty()){
            Pair top=pq.poll();
            int u=top.vertex;
            int t=top.time;
            for (Pair p:adj.get(u)){
                int nt=p.time;
                int v=p.vertex;
                if (nt+t<minTime[v]){
                    minTime[v]=nt+t;
                    pq.offer(new Pair(v,nt+t));
                }
            }
        }
        int res=0;
        for (int i:minTime){
            if (i>res) res=i;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}