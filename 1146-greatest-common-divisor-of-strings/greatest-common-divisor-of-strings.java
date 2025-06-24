class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String smaller=str1.length()>str2.length()?str2:str1;
        String larger=str1.length()>str2.length()?str1:str2;
        if (smaller.equals(larger)) return smaller;
        if (!larger.startsWith(smaller)) return "";
        return gcdOfStrings(larger.substring(smaller.length()),smaller);
    }
}