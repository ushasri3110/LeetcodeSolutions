class Solution {
    public String convert(String s, int numRows) {
        if (s.length()<numRows||numRows==1){
            return s;
        }
        ArrayList<Character> arr[]=new ArrayList[numRows];
        for (int i=0;i<numRows;i++){
            arr[i]=new ArrayList<>();
        }
        int index=0;
        int j=1;
        for (char c : s.toCharArray()){
            arr[index].add(c);
            if(index==0){
                j=1;
            }
            else if (index==numRows-1){
                j=-1;
            }
            index=index+j;
        }
        StringBuilder sb=new StringBuilder();
        for (ArrayList<Character> row :arr){
            for (char c : row){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}