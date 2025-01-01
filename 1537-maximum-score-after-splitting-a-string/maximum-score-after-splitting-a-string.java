class Solution {
    public int maxScore(String s) {
        int maxScore=0;
        int rightOnes=0;
        int leftZeros=0;
        int j=0;
        for (char ch:s.toCharArray()){
            if (ch=='1'){
                rightOnes++;
            }
        }
        while(j<s.length()-1){
            if (s.charAt(j)=='0'){
                leftZeros++;
            }
            else{
                rightOnes--;
            }
            maxScore=Math.max(maxScore,leftZeros+rightOnes);
            j++;
        }
        return maxScore;
    }
}