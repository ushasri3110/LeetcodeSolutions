class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int j=s.length();
        while (j>0){
            if (s.charAt(j-1)==' ') break;
            j--;
        }
        return s.length()-j;
    }
}