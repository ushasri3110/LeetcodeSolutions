class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length()!=word2.length()){
            return false;
        }
        int word1f[]=new int[26];
        int word2f[]=new int[26];
        for (char c:word1.toCharArray()){
            word1f[c-'a']++;
        }
        for (char c:word2.toCharArray()){
            word2f[c-'a']++;
        }
        for (int i=0;i<26;i++){
            if (word1f[i]==0&&word2f[i]!=0){
                return false;
            }
        }
        Arrays.sort(word1f);
        Arrays.sort(word2f);
        for (int i=0;i<26;i++){
            if (word1f[i]!=word2f[i]){
                return false;
            }
        }
        return true;
    }
}