class Solution {
    public List<String> commonChars(String[] words) {
       int minFreq[]=new int[26];
        for (int i = 0; i < 26; i++) {
            minFreq[i] = Integer.MAX_VALUE;
        }
       for (int i=0;i<words.length;i++){
        int currFreq[]=new int[26];
        for (char c:words[i].toCharArray()){
            currFreq[c-'a']++;
        }
        for (int j=0;j<26;j++){
            minFreq[j]=Math.min(minFreq[j],currFreq[j]);
            // System.out.print(minFreq[j]+" ");
        }
        
       }
       List<String> output=new ArrayList<>();
       for (int i=0;i<26;i++){
        for (int j=0;j<minFreq[i];j++){
            output.add(Character.toString(i+'a'));
        }
       }
       return output;
    }
}