class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length()<k) return false;
        int[] freq=new int[26];
        for (char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int singles=0;
        for (int i=0;i<26;i++){
            if (freq[i]%2!=0) singles++;
        }
        return singles<=k;
    }
}