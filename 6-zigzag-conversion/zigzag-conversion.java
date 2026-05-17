class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1) return s;
        StringBuilder sb=new StringBuilder();
        List<List<Character>> arr=new ArrayList<>();
        for (int i=0;i<numRows;i++){
            arr.add(new ArrayList<>());
        }
        int i=0;
        int dir=1;
        for (char ch:s.toCharArray()){
            arr.get(i).add(ch);
            if (i==0){
                dir=1;
            }
            else if (i==numRows-1){
                dir=-1;
            }
            i+=dir;
        }
        for (List<Character> row:arr){
            for (char ch:row){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}