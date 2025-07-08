class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> visited=new HashSet<>();
        int longest=0;
        int start=0;
        for (int end=0;end<s.length();end++){
            char current=s.charAt(end);
            if (!visited.contains(current)){
                visited.add(current);
                longest=Math.max(longest,end-start+1);
            }
            else{
                while (s.charAt(start)!=current){
                    visited.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return longest;
    }
}