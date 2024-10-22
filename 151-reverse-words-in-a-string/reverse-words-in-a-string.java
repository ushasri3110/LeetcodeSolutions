class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String arr[]=s.split(" +");
        int i=arr.length-1;
        String res="";
        while (i>=0){
            res+=arr[i];
            res+=" ";
            i--;
        }
        return res.trim();
    }
}