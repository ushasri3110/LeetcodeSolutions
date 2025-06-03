class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] res=new int[n];
        int[] freq=new int[n+1];
        int count=0;
        for (int i=0;i<n;i++){
            int a=A[i];
            int b=B[i];
            freq[a]+=1;
            if (freq[a]==2) count++;
            freq[b]+=1;
            if (freq[b]==2) count++;
            res[i]=count;
        }
        return res;
    }
}