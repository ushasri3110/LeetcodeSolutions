class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums1[i];
            arr[i][1]=nums2[i];
        }
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        long sum=0;
        long res=0;
        for (int[] i:arr){
            pq.add(i[0]);
            sum+=(long)i[0];
            if (pq.size()>k) sum-=pq.poll();
            if (pq.size()==k) res=Math.max(res,(long)sum*i[1]);
        }
        return res;
    }
}