class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] buckets=new int[n+1];
        for (int c:citations){
            if (c>=n){
                buckets[n]++;
            }
            else{
                buckets[c]++;
            }
        }
        int total=0;
        for (int i=n;i>=0;i--){
            total+=buckets[i];
            if (total>=i) return i;
        }
        return 0;
    }
}