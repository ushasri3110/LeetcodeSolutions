class Solution {
    public int numberOfPairs(int[][] points) {
        int n=points.length;
        int count=0;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        for (int j=n-1;j>=0;j--){
            int x=points[j][0];
            int y=points[j][1];
            int minY=Integer.MAX_VALUE;
            for (int i=j-1;i>=0;i--){
                int xx=points[i][0];
                int yy=points[i][1];
                if (yy>=minY || yy<y) continue;
                count++;
                minY=yy;
            }
        }
        return count;
    }
}