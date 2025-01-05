class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int diffArray[] = new int[n];
        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                diffArray[shift[0]]++;
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]--;
                }
            }
            else{
                diffArray[shift[0]]--;
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]++;
                }
            }
        }
        StringBuilder sb=new StringBuilder(s);
        int numShifts=0;
        for (int i=0;i<n;i++){
            numShifts=(numShifts+diffArray[i])%26;
            if (numShifts<0){
                numShifts+=26;
            }
            char ch=(char)('a'+((s.charAt(i)-'a'+numShifts)%26));
            sb.setCharAt(i,ch);
        }
        return sb.toString();
    }
}