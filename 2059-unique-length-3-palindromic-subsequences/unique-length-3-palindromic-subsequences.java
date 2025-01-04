class Solution {
    public int countPalindromicSubsequence(String s) {
        int count=0;
        int first[]=new int[26];
        int last[]=new int[26];
        Arrays.fill(first,-1);

        for (int i=0;i<s.length();i++){
            int curr=s.charAt(i)-'a';
            if (first[curr]==-1){
                first[curr]=i;
            }
            last[curr]=i;
        }
        for (int i=0;i<26;i++){
            if (first[i]==-1){
                continue;
            }
            Set<Character> between=new HashSet<>();
            for(int j=first[i]+1;j<last[i];j++){
                between.add(s.charAt(j));
            }
            count+=between.size();
        }
        return count;
    }
}