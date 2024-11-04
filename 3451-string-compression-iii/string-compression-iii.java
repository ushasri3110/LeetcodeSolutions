class Solution {
    public String compressedString(String word) {
        String comp="";
        int pos=0;
        while (pos<word.length()){
            int count=0;
            char current=word.charAt(pos);
            while(pos<word.length() && count<9 && word.charAt(pos)==current){
                count++;
                pos++;
            }
            comp+=count;
            comp+=current;
        }
        return comp;
    }
}