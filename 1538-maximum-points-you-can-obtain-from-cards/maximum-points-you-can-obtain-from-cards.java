class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int left=0;
        while (left<k){
            sum+=cardPoints[left];
            left++;
        }
        left=k-1;
        int right=cardPoints.length-1;
        int maxSum=sum;
        while (left>=0){
            sum-=cardPoints[left];
            sum+=cardPoints[right];
            maxSum=Math.max(sum,maxSum);
            left--;
            right--;
        }
        return maxSum;
    }
}