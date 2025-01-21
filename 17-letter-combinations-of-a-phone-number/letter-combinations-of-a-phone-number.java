class Solution {
    List<String> result=new ArrayList<>();
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
            combinationsHelper(map,digits,"",0);
        }
        return result;
    }
    public void combinationsHelper(Map<Character,String> map,String digits,String currentStr,int i){
        if (currentStr.length()==digits.length()){
            result.add(currentStr);
            return;
        }
        for (Character ch:map.get(digits.charAt(i)).toCharArray()){
            combinationsHelper(map,digits,currentStr+ch,i+1);
        }
    }
}