class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int n=s.length();
        int start=0;
        int end=0;
        int maxLength=0;
        while (end<n){
            char ch=s.charAt(end);
            if (!set.contains(ch)){
                set.add(ch);
                maxLength=Math.max(maxLength,end-start+1);
            }
            else{
                while (s.charAt(start)!=ch){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            end++;
        }
        return maxLength;
    }
}