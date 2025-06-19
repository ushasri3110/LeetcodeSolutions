class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> r=new HashMap<>();
        Map<Character,Integer> m=new HashMap<>();
        for (char ch:ransomNote.toCharArray()){
            r.put(ch,r.getOrDefault(ch,0)+1);
        }
        for (char ch:magazine.toCharArray()){
            m.put(ch,m.getOrDefault(ch,0)+1);
        }
        for (char ch:r.keySet()){
            if (r.get(ch)>m.getOrDefault(ch,0)){
                return false;
            }
        }
        return true;
    }
}