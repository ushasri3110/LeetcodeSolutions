class Solution {
    public int minimumLength(String s) {
        int[] freq=new int[26];
        int totalLength=0;
        for (char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for (int i=0;i<26;i++){
            if (freq[i]==0) continue;
            if (freq[i]%2==0) totalLength+=2;
            else totalLength+=1;
        }
        return totalLength;
    }
}