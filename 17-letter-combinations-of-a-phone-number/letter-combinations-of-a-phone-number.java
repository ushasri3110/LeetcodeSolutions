class Solution {
    List<String> result=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if (digits.length()>0){
            letterCombinationsHelper(digits,map,0,"");
        }
        return result;
    }
    public void letterCombinationsHelper(String digits,HashMap<Character,String> map,int i,String currentStr){
        if (currentStr.length()==digits.length()){
            result.add(currentStr);
            return;
        }
        for (char c : map.get(digits.charAt(i)).toCharArray()){
            letterCombinationsHelper(digits,map,i+1,currentStr+c);
        }
    }
}