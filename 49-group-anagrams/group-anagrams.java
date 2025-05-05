class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> frequencyMap=new HashMap<>();
        for (String str:strs){
            String freqKey=getFrequencyKey(str);
            if (frequencyMap.containsKey(freqKey)){
                frequencyMap.get(freqKey).add(str);
            }
            else{
                List<String> newList=new ArrayList<>();
                newList.add(str);
                frequencyMap.put(freqKey,newList);
            }
        }
        return new ArrayList<>(frequencyMap.values());
    }
    public String getFrequencyKey(String str){
        int[] freq=new int[26];
        for (char c:str.toCharArray()){
            freq[c-'a']++;
        }
        char ch='a';
        StringBuilder sb=new StringBuilder();
        for (int i:freq){
            sb.append(ch);
            sb.append(i);
            ch++;
        }
        return sb.toString();
    }
}