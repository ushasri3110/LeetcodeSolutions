class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] res=new int[n];
        int rightOnes=0;
        int total=0;
        int prefixSum=0;
        int leftOnes=0;
        for (int i=0;i<n;i++){
            if (boxes.charAt(i)=='1'){
                rightOnes++;
                total+=i;
            }
        }
        for (int i=0;i<n;i++){
            int moves=total+prefixSum;
            res[i]=moves;
            if (boxes.charAt(i)=='1'){
                leftOnes++;
                rightOnes--;
            }
            prefixSum+=leftOnes;
            total-=rightOnes;
        }
        return res;
    }
}