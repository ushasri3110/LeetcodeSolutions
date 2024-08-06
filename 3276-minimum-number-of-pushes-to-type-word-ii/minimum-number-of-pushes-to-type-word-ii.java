class Solution {
    public int minimumPushes(String word) {
        int charArray[]=new int[26];
        int res=0;
        for (char c:word.toCharArray()){
            charArray[c-'a']++;
        }
        Arrays.sort(charArray);
        for (int i=0;i<26;i++){
            res=res+charArray[26-i-1]*(i/8+1);
        }
        return res;
    }
}