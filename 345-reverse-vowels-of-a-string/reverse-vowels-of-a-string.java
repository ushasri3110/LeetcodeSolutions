class Solution {
    public boolean isVowel(char ch){
        if (ch=='a'||ch=='A'||ch=='e'||ch=='E'||ch=='i'||ch=='I'||ch=='o'||ch=='O'||ch=='u'||ch=='U'){
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        int i=0;
        char ch[]=s.toCharArray();
        int j=s.length()-1;
        while (i<j){
            if (!isVowel(ch[i])){
                i++;
            }
            else if (!isVowel(ch[j])){
                j--;
            }
            else{
                char temp=ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
            }
        }
        return String.valueOf(ch);
    }
}