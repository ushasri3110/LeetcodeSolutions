class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        List<List<Character>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            res.add(new ArrayList<>());
        }
        int i=0;
        int j=1;
        for (char c:s.toCharArray()){
            res.get(i).add(c);
            if (i==0){
                j=1;
            }
            else if (i==numRows-1){
                j=-1;
            }
            i=i+j;
        }
        StringBuilder sb=new StringBuilder();
        for (List<Character> row:res){
            for (char c:row){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}