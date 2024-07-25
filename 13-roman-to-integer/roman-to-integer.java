class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int result=0;
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for (int i=0;i<s.length()-1;i++){
            char current=s.charAt(i);
            char next=s.charAt(i+1);
            if (map.get(current)<map.get(next)){
                result-=map.get(current);
            }
            else{
                result+=map.get(current);
            }
        }
        result+=map.get(s.charAt(s.length()-1));
        return result;
    }
}