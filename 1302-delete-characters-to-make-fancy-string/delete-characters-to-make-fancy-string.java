class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        char prev=s.charAt(0);
        int count=1;
        sb.append(prev);
        for (int i=1;i<s.length();i++){
            if(s.charAt(i)==prev){
                count++;
            }
            else{
                prev=s.charAt(i);
                count=1;
            }
            if (count<3){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}