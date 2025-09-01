class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Double.compare(gain(b),gain(a)));
        for (int[] c:classes){
            pq.offer(c);
        }
        while (extraStudents>0){
            int[] cur=pq.poll();
            cur[0]++;
            cur[1]++;
            pq.offer(cur);
            extraStudents--;
        }
        double res=0.0;
        while (!pq.isEmpty()){
            int[] cur=pq.poll();
            res+=(double) cur[0]/cur[1];
        }
        return res/classes.length;
    }
    public double gain(int[] c){
        return (double) (c[0]+1)/(c[1]+1)- (double)c[0]/c[1];
    }
}