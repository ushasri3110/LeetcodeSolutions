class Solution {
    public boolean isVowel(char ch){
        if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ps=new int[words.length];
        for (int i=0;i<words.length;i++){
            String current=words[i];
            if (isVowel(current.charAt(0)) && isVowel(current.charAt(current.length()-1))){
                ps[i]=i>0?ps[i-1]+1:1;
            }
            else{
                ps[i]=i>0?ps[i-1]:0;
            }
        }
        int[] res=new int[queries.length];
        for (int i=0;i<queries.length;i++){
            int count=0;
            int start=queries[i][0];
            int end=queries[i][1];
            if (start>0){
                count=ps[end]-ps[start-1];
            }
            else{
                count=ps[end];
            }
            res[i]=count;
        }
        return res;
    }
}