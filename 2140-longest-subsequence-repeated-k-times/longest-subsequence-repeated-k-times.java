class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        List<Character> candidates=new ArrayList<>();
        for (int i=0;i<freq.length;i++){
            if (freq[i]>=k) candidates.add((char)('a'+i));
        }
        Queue<String> q=new LinkedList<>();
        for (char ch:candidates){
            q.offer(String.valueOf(ch));
        }
        String longest="";
        while(!q.isEmpty()){
            String current=q.poll();
            if (longest.length()<=current.length()) longest=current;
            for (char ch:candidates){
                String newWord=current+ch;
                if (isRepeatedKTimes(s,newWord,k)){
                    q.offer(newWord);
                }
            }
        }
        return longest;
    }
    private boolean isRepeatedKTimes(String str,String sub,int k){
        int pos=0;
        int count=0;
        for (char ch:str.toCharArray()){
            if (ch==sub.charAt(pos)){
                pos++;
            }
            if (pos==sub.length()){
                pos=0;
                count++;
            }
            if (count>=k){
                return true;
            }
        }
        return false;
    }
}