class Solution {
    public boolean isVowel(char ch){
        if (ch=='a' || ch=='A' || ch=='e' || ch=='E' || ch=='i' || ch=='I' || ch=='o' || ch=='O' || ch=='u' || ch=='U'){
            return true;
        }
        return false;
    }
    public boolean isValid(String word) {
        if (word.length()<3) return false;
        boolean containsVowel=false;
        boolean containsConsonant=false;
        for (char ch:word.toCharArray()){
            if (ch>='0' && ch<='9') continue;
            else if ((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
                if (isVowel(ch)) containsVowel=true;
                else containsConsonant=true;
            }
            else return false;
        }
        return containsVowel && containsConsonant;
    }
}