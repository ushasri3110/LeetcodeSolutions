class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        if (strs.length==1){
            return strs[0];
        }
        String first=strs[0];
        String last=strs[strs.length-1];
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<first.length();i++){
            if (first.charAt(i)!=last.charAt(i)){
                return sb.toString();
            }
            sb.append(first.charAt(i));
        }
        return sb.toString();
    }
}