class Solution {
    public boolean isVowel(char c){
        if (c=='a'||c=='A'||c=='e'||c=='E'||c=='i'||c=='I'||c=='o'||c=='O'||c=='u'||c=='U'){
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        char[] arr=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(!isVowel(arr[i])){
                i++;
            }
            else if(!isVowel(arr[j])){
                j--;
            }
            else{
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }

        }
        return String.valueOf(arr);
    }
}