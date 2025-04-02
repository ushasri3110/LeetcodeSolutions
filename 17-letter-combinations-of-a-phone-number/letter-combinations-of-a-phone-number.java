class Solution {
    List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if (digits.length()>0){
            combinationsHelper("",digits,map,0);
        }
        return res;
    }
    private void combinationsHelper(String current,String digits,Map<Character,String> map,int i){
        if (current.length()==digits.length()){
            res.add(current);
            return;
        }
        for (char ch:map.get(digits.charAt(i)).toCharArray()){
            combinationsHelper(current+ch,digits,map,i+1);
        }
    }
}