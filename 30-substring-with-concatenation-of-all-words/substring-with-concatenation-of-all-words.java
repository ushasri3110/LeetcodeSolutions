class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if (s.length()==0||words.length==0) return res;
        int numWords=words.length;
        int wordLength=words[0].length();
        int totalLength=numWords*wordLength;
        Map<String,Integer> wordCount=new HashMap<>();
        for (String str:words){
            wordCount.put(str,wordCount.getOrDefault(str,0)+1);
        }
        for (int i=0;i<wordLength;i++){
            int left=i;
            Map<String,Integer> windowMap=new HashMap<>();
            int count=0;
            for (int right=i;right+wordLength<=s.length();right+=wordLength){
                String word=s.substring(right,right+wordLength);
                if (wordCount.containsKey(word)){
                    windowMap.put(word,windowMap.getOrDefault(word,0)+1);
                    count++;
                    while (windowMap.get(word)>wordCount.get(word)){
                        String leftWord=s.substring(left,left+wordLength);
                        windowMap.put(leftWord,windowMap.get(leftWord)-1);
                        count--;
                        left+=wordLength;
                    }
                    if (count==numWords){
                        res.add(left);
                    }
                }
                else{
                    windowMap.clear();
                    count=0;
                    left=right+wordLength;
                }
            }
        }
        return res;
    }
}