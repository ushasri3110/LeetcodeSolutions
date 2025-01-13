class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        if (n<3){
            return n;
        }
        int freq[]=new int[26];
        int minLength=0;
        for (char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for (int f:freq){
            if(f==0){
                continue;
            }
            if (f%2==0){
                minLength=minLength+2;
            }
            else{
                minLength=minLength+1;
            }
        }


        return minLength;
    }
}