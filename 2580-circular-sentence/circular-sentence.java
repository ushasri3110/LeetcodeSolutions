class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] strArr=sentence.split(" ");
        int n=strArr.length;
        for (int i=0;i<n;i++){
            int m=strArr[i].length()-1;
            if (i==n-1){
                if (strArr[i].charAt(m)!=strArr[0].charAt(0)){
                    return false;
                }
            }
            else{
                if (strArr[i].charAt(m)!=strArr[i+1].charAt(0)){
                    return false;
                }
            }
        }
        return true;
    }
}