
class Solution {
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int res[] = new int[queries.length];
        int prefixSum[] = new int[words.length];
        int count=0;
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            if (isVowel(current.charAt(0)) && isVowel(current.charAt(current.length() - 1))) {
                count++;
            }
            prefixSum[i] = count;
        }
        for (int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if (start==0){
                res[i]=prefixSum[end];
            }
            else {
                res[i] = prefixSum[end] - prefixSum[start - 1];
            }
        }

        return res;
    }
}