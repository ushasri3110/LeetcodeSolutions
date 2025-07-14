class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return "";

        // Build frequency map for characters in t
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0; // Total number of characters matched
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < m) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // If rightChar is needed and count matches, increment match count
            if (freqMap.containsKey(rightChar) &&
                windowMap.get(rightChar).intValue() <= freqMap.get(rightChar).intValue()) {
                count++;
            }

            // Try to shrink window if all characters are matched
            while (count == n) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // If removing leftChar breaks the match, reduce count
                if (freqMap.containsKey(leftChar) &&
                    windowMap.get(leftChar) < freqMap.get(leftChar)) {
                    count--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}