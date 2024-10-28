class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<magazine.length();i++){
           char ch=magazine.charAt(i);
           if (map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
           }
           else{
            map.put(ch,1);
           }
        }
        for (int j=0;j<ransomNote.length();j++){
            char ch=ransomNote.charAt(j);
            Integer freq=map.get(ch);
            if (map.containsKey(ch) && freq>0){
                map.put(ch,freq-1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}