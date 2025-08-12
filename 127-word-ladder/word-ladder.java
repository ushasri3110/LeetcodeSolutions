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
        Set<String> set=new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair top=q.poll();
            String current=top.word;
            int currentLength=top.length;
            char[] wordChar=current.toCharArray();
            for (int i=0;i<wordChar.length;i++){
                char originalChar=wordChar[i];
                for (char ch='a';ch<='z';ch++){
                    if (originalChar==ch) continue;
                    wordChar[i]=ch;
                    String newWord=new String(wordChar);
                    if (newWord.equals(endWord)) return currentLength+1;
                    if (set.contains(newWord)){
                        q.offer(new Pair(newWord,currentLength+1));
                        set.remove(newWord);
                    }
                }
                wordChar[i]=originalChar;
            }
        }
        return 0;
    }
}
