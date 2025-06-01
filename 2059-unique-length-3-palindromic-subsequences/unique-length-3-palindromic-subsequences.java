class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first=new int[26];
        int[] last=new int[26];
        Arrays.fill(first,-1);
        for (int i=0;i<n;i++){
            int current=s.charAt(i)-'a';
            if (first[current]==-1) first[current]=i;
            last[current]=i;
        }
        int count=0;
        for (int i=0;i<26;i++){
            if (first[i]==-1) continue;
            Set<Character> between=new HashSet<>();
            for (int j=first[i]+1;j<last[i];j++){
                between.add(s.charAt(j));
            }
            count+=between.size();
        }
        return count;
    }
}