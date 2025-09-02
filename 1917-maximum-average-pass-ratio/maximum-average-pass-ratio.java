class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Double.compare(gain(b),gain(a)));
        for (int[] c:classes){
            pq.offer(c);
        }
        while (extraStudents>0){
            int[] c=pq.poll();
            c[0]++;
            c[1]++;
            pq.offer(c);
            extraStudents--;
        }
        double res=0.0;
        while (!pq.isEmpty()){
            int[] c=pq.poll();
            res+= (double) c[0]/c[1];
        }
        return res/classes.length;
    }
    public double gain(int[] c){
        return (double) (c[0]+1)/(c[1]+1) - (double) c[0]/c[1];
    }
}