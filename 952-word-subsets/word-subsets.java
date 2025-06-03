class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq=new int[26];
        List<String> res=new ArrayList<>();
        for (String word:words2){
            int[] freq=countFreq(word);
            for (int i=0;i<26;i++){
                maxFreq[i]=Math.max(maxFreq[i],freq[i]);
            }
        }
        for (String word:words1){
            int[] freq=countFreq(word);
            boolean isUniversal=true;
            for (int i=0;i<26;i++){
                if (maxFreq[i]>freq[i]){
                    isUniversal=false;
                    break;
                }
            }
            if (isUniversal) res.add(word);
        }
        return res;
    }
    private int[] countFreq(String word){
        int[] freq=new int[26];
        for (char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        return freq;
    }
}