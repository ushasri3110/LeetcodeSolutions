class Solution {
    public String sortSentence(String s) {
        Map<Integer,String> map=new HashMap<>();
        int count=0;
        for (String word:s.split(" ")){
            int index=word.charAt(word.length()-1)-'0';
            count++;
            map.put(index,word.substring(0,word.length()-1));
        }
        StringBuilder sb=new StringBuilder();
        for (int i=1;i<=count;i++){
            sb.append(map.get(i));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}