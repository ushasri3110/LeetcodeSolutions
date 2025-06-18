class Pair {
    String word;
    int length;

    Pair(String word, int length) {
        this.word = word;
        this.length = length;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            String current = top.word;
            int currentLength = top.length;
            char[] wordChars = current.toCharArray();
            for (int pos = 0; pos < wordChars.length; pos++) {
                char originalChar = wordChars[pos];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue; 
                    wordChars[pos] = c;
                    String newWord = new String(wordChars);
                    if (newWord.equals(endWord)) {
                        return currentLength + 1;
                    }
                    if (wordSet.contains(newWord)) {
                        q.offer(new Pair(newWord, currentLength + 1));
                        wordSet.remove(newWord); 
                    }
                }
                wordChars[pos] = originalChar;
            }
        }

        return 0; 
    }
}
