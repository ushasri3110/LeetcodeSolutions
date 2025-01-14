class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int C[]=new int[n];
        int freq[]=new int[n+1];
        int commonCount=0;
        for (int i=0;i<n;i++){
            freq[A[i]]+=1;
            if (freq[A[i]]==2){
                commonCount++;
            }
            freq[B[i]]+=1;
            if (freq[B[i]]==2){
                commonCount++;
            }
            C[i]=commonCount;
        }
        return C;
    }
}