import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if (s.length() < totalLength) {
            return result;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i, count = 0;
            HashMap<String, Integer> visited = new HashMap<>();

            for (int right = i; right <= s.length() - wordLength; right += wordLength) {
                String word = s.substring(right, right + wordLength);
                if (map.containsKey(word)) {
                    visited.put(word, visited.getOrDefault(word, 0) + 1);
                    count++;

                    while (visited.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        visited.put(leftWord, visited.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    visited.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}
