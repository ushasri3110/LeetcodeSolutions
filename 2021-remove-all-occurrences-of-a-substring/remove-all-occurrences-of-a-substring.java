class Solution {

    public String removeOccurrences(String s, String part) {
        int[] kmpLPS = computeLongestPrefixSuffix(part);
        Stack<Character> charStack = new Stack<>();

        int[] patternIndexes = new int[s.length() + 1];

        for (
            int strIndex = 0, patternIndex = 0;
            strIndex < s.length();
            strIndex++
        ) {
            char currentChar = s.charAt(strIndex);
            charStack.push(currentChar);

            if (currentChar == part.charAt(patternIndex)) {
                patternIndexes[charStack.size()] = ++patternIndex;

                if (patternIndex == part.length()) {
                    int remainingLength = part.length();
                    while (remainingLength != 0) {
                        charStack.pop();
                        remainingLength--;
                    }
                    patternIndex = charStack.isEmpty()
                        ? 0
                        : patternIndexes[charStack.size()];
                }
            } else {
                if (patternIndex != 0) {
                    strIndex--;
                    patternIndex = kmpLPS[patternIndex - 1];
                    charStack.pop();
                } else {
                    patternIndexes[charStack.size()] = 0;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            result.append(charStack.pop());
        }

        return result.reverse().toString();
    }

    private int[] computeLongestPrefixSuffix(String pattern) {
        int[] lps = new int[pattern.length()];
        for (int current = 1, prefixLength = 0; current < pattern.length();) {
            if (pattern.charAt(current) == pattern.charAt(prefixLength)) {
                lps[current] = ++prefixLength;
                current++;
            }
            else if (prefixLength != 0) {
                prefixLength = lps[prefixLength - 1];
            }
            else {
                lps[current] = 0;
                current++;
            }
        }
        return lps;
    }
}