class Solution {
    public List<String> stringMatching(String[] words) {
        int n=words.length;
        List<String> res=new ArrayList<>();
        Arrays.sort(words,Comparator.comparingInt(String::length));
        for (int i=0;i<n;i++){
            int[] lps=computeLPSArray(words[i]);
            for (int j=i+1;j<n;j++){
                if (checkSubstring(words[i],words[j],lps)){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
    private int[] computeLPSArray(String str){
        int[] lps=new int[str.length()];
        int i=0;
        int j=1;
        while (j<str.length()){
            if (str.charAt(j)==str.charAt(i)){
                i++;
                lps[j]=i;
                j++;
            }
            else{
                if (i>0) i=lps[i-1];
                else j++;
            }
        }
        return lps;
    }
    private boolean checkSubstring(String s1,String s2,int[] lps){
        int i1=0;
        int i2=0;
        while (i2<s2.length()){
            if (s2.charAt(i2)==s1.charAt(i1)){
                i1++;
                i2++;
                if (i1==s1.length()) return true;
            }
            else{
                if (i1>0) i1=lps[i1-1];
                else i2++;
            }
        }
        return false;
    }
}