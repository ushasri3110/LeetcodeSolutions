class Solution {
    public String countAndSay(int n) {
        if (n==1) return "1";
        StringBuilder number=new StringBuilder("1");
        for(int i=2;i<=n;i++){
            StringBuilder sb=new StringBuilder();
            int count=1;
            char current=number.charAt(0);
            for (int j=1;j<number.length();j++){
                if (number.charAt(j)==current){
                    count++;
                }
                else{
                    sb.append(count).append(current);
                    count=1;
                    current=number.charAt(j);
                }
            }
            sb.append(count).append(current);
            number=sb;
        }
        return number.toString();
    }
}