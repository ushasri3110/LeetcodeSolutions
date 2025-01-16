class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        List<List<Character>> list=new ArrayList<>();
        for (int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
        }
        int i=0;
        int reverse=1;
        for (char c:s.toCharArray()){
            list.get(i).add(c);
            if (i==0){
                reverse=1;
            }
            else if (i==numRows-1){
                reverse=-1;
            }
            i=i+reverse;
        }
        for (List<Character> sub:list){
            for (char ch:sub){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}