class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1 || s.length()<numRows){
            return s;
        }
        List<List<Character>> arr=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<numRows;i++){
            arr.add(new ArrayList<>());
        }
        int i=0;
        int direction=1;
        for (char ch:s.toCharArray()){
            arr.get(i).add(ch);
            if (i==0){
                direction=1;
            }
            else if (i==numRows-1){
                direction=-1;
            }
            i=i+direction;
        }
        for (List<Character> row:arr){
            for (char ch:row){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}