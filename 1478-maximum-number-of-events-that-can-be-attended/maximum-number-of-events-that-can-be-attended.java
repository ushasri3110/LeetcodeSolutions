class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int n=events.length;
        int pos=0;
        int time=1;
        int attended=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        while (pos<n || !pq.isEmpty()){
            if (pq.isEmpty()){
                time=Math.max(time,events[pos][0]);
            }
            while (pos<n && events[pos][0]==time){
                pq.offer(events[pos][1]);
                pos++;
            }
            while (!pq.isEmpty() && pq.peek()<time){
                pq.poll();
            }
            if (!pq.isEmpty()){
                pq.poll();
                attended++;
            }
            time++;
        }
        return attended;
    }
}