class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        Arrays.sort(strs);
        for (int i=0;i<strs[0].length();i++){
            if (strs[0].charAt(i)!=strs[strs.length-1].charAt(i)){
                return sb.toString();
            }
            else{
                sb.append(strs[0].charAt(i));
            }
        }
        return sb.toString();
    }
}