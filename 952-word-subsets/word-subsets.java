class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res=new ArrayList<>();
        int[] maxWordCount2 = new int[26];
        for (String str:words2){
            int[] tempCount = new int[26];
            for (char ch : str.toCharArray()) {
                tempCount[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxWordCount2[i] = Math.max(maxWordCount2[i], tempCount[i]);
            }
        }
        for (String a : words1) {
            int[] wordCount1 = new int[26];
            for (char ch : a.toCharArray()) {
                wordCount1[ch - 'a']++;
            }
            
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (wordCount1[i] < maxWordCount2[i]) {
                    isUniversal = false;
                    break;
                }
            }
            
            if (isUniversal) {
                res.add(a);
            }
        }
        return res;
    }
}