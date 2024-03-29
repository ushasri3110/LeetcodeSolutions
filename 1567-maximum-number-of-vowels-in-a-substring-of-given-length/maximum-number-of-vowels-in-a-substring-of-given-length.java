class Solution {
    public boolean isVowel(char ch){
        if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int count=0;
        for (int i=0;i<k;i++){
            if (isVowel(s.charAt(i))){
                count++;
            }
        }
        int max_vowels=count;
        int i=0;
        int j=k;
        while (j<s.length()){
            if (isVowel(s.charAt(i))){
                count--;
            }
            if (isVowel(s.charAt(j))){
                count++;
            }
            i++;
            j++;
            max_vowels=Math.max(count,max_vowels);
        }
        return max_vowels;
    }
}