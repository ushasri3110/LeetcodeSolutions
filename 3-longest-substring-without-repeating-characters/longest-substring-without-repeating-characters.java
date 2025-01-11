class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int i=0;
        int j=0;
        int longest=0;
        while (j<s.length()){
            char currentChar=s.charAt(j);
            if (set.contains(currentChar)){
                while (s.charAt(i)!=currentChar){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            else{
                set.add(currentChar);
                longest=Math.max(longest,j-i+1);
            }
            j++;
        }

        return longest;
    }
}