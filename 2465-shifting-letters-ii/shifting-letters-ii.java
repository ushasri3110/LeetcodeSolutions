class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff=new int[s.length()+1];
        for (int[] shift:shifts){
            if (shift[2]==1){
                diff[shift[0]]++;
                diff[shift[1]+1]--;
            }
            else{
                diff[shift[0]]--;
                diff[shift[1]+1]++;
            }
        }
        for (int i=1;i<s.length();i++){
            diff[i]+=diff[i-1];
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            int count=diff[i]%26;
            if (count<0) count+=26;
            sb.append((char)('a'+ (s.charAt(i)-'a'+count)%26));
        }
        return sb.toString();
    }
}