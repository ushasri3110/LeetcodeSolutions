class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int low=0,high=n-1;
        while (low<=high){
            int mid=(low+high)/2;
            int maxRow=0;
            for (int i=1;i<m;i++){
                if (mat[maxRow][mid]<mat[i][mid]) maxRow=i;
            }
            int left=(mid-1>=0)?mat[maxRow][mid-1]:-1;
            int right=(mid+1<n)?mat[maxRow][mid+1]:-1;
            int current=mat[maxRow][mid];
            if (current>left && current>right){
                return new int[]{maxRow,mid};
            }
            else if (current<left) high=mid;
            else low=mid+1;
        }
        return new int[]{-1,-1};
    }
}