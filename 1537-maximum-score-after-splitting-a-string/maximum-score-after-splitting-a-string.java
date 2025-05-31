class Solution {
    public int maxScore(String s) {
        int zeros=0;
        int ones=0;
        int score=0;
        for (char ch:s.toCharArray()){
            if (ch=='1') ones++;
        }
        for (int i=0;i<s.length()-1;i++){
            char ch=s.charAt(i);
            if (ch=='0') zeros++;
            else ones--;
            score=Math.max(score,zeros+ones);
        }
        return score;
    }
}