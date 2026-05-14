class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        Set<Character> set=new HashSet<>();
        int start=0;
        int end=0;
        while (end<s.length()){
            char c=s.charAt(end);
            if (set.contains(c)){
                while(s.charAt(start)!=c){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            else{
                ans=Math.max(ans,end-start+1);
                set.add(s.charAt(end));
            }
            end++;
        }
        return ans;
    }
}