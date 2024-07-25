class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        int n=strs.length;
        Arrays.sort(strs);
        for (int i=0;i<strs[0].length();i++){
            if (strs[0].charAt(i)==strs[n-1].charAt(i)){
                sb.append(strs[0].charAt(i));
            }
            else
            {
                break;
            }
        }
        return sb.toString();
    }
}