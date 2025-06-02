class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int count=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                String s1=words[i];
                String s2=words[j];
                if (isPrefixAndSuffix(s1,s2)) count++;
            }
        }
        return count;
    }
    private boolean isPrefixAndSuffix(String s1,String s2){
        if (s2.startsWith(s1) && s2.endsWith(s1)) return true;
        return false;
    }
}