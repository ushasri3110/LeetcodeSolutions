class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        String longest_palindrome = "";
        for (int i = 0; i < s.length(); i++) {
            int low = i;
            int high = i;
            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) {
                    break;
                }
            }
            String current_palindrome = s.substring(low + 1, high);
            if (longest_palindrome.length() < current_palindrome.length()) {
                longest_palindrome = current_palindrome;
            }
            low = i - 1;
            high = i;
            while (low>=0&&s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) {
                    break;
                }
            }
            current_palindrome = s.substring(low + 1, high);
            if (longest_palindrome.length() < current_palindrome.length()) {
                longest_palindrome = current_palindrome;
            }
        }
        return longest_palindrome;
    }
}