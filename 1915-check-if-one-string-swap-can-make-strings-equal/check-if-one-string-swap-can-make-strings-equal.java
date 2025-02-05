class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int mismatch = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != (s2.charAt(i))) {
                mismatch++;
                if (mismatch > 2) {
                    return false;
                } else if (mismatch == 1) {
                    firstIndex = i;
                } else {
                    secondIndex = i;
                }
            }
        }
        return s1.charAt(firstIndex) == s2.charAt(secondIndex) && s1.charAt(secondIndex) == s2.charAt(firstIndex);
    }
}