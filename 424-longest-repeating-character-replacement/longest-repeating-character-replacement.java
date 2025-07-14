class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int start=0, maxLength=0, maxFreq=0;
        for (int end=0;end<s.length();end++){
            freq[s.charAt(end)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(end)-'A']);
            while ((end-start+1)-maxFreq >k){
                char leftChar=s.charAt(start);
                freq[leftChar-'A']--;
                for (int i:freq) maxFreq=Math.max(maxFreq,i);
                start++;
            }
            maxLength=Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
}