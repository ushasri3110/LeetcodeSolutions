class Solution {
    public boolean isVowel(char ch){
        if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' ||ch=='U'){
            return true;
        }
        return false;
    }
    public String sortVowels(String s) {
        List<Character> vowels=new ArrayList<>();
        for (char ch:s.toCharArray()){
            if (isVowel(ch)){
                vowels.add(ch);
            }
        }
        Collections.sort(vowels);
        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        while (i<s.length()){
            if (isVowel(s.charAt(i))){
                sb.append(vowels.get(j));
                j++;
            }
            else{
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}