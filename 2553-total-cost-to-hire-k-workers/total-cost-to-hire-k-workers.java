class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long total=0;
        PriorityQueue<Integer> leftPq=new PriorityQueue<>();
        PriorityQueue<Integer> rightPq=new PriorityQueue<>();
        int left=0, right=costs.length-1;
        for (int i=0;i<k;i++){
            while (leftPq.size()<candidates && left<=right) leftPq.add(costs[left++]);
            while (rightPq.size()<candidates && left<=right) rightPq.add(costs[right--]);
            int t1=leftPq.size()>0?leftPq.peek():Integer.MAX_VALUE;
            int t2=rightPq.size()>0?rightPq.peek():Integer.MAX_VALUE;
            if (t1<=t2){
                total+=(long) t1;
                leftPq.poll();
            }
            else{
                total+=(long) t2;
                rightPq.poll();
            }

        }
        return total;
    }
}