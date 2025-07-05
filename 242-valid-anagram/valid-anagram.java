class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] sFreq=new int[26];
        int[] tFreq=new int[26];
        for (char ch:s.toCharArray()) sFreq[ch-'a']++;
        for (char ch:t.toCharArray()) tFreq[ch-'a']++;
        for (int i=0;i<26;i++){
            if (sFreq[i]!=tFreq[i]) return false;
        }
        return true;
    }
}