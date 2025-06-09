class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int[] result=new int[m+n];
        for (int i=m-1;i>=0;i--){
            int digit1=num1.charAt(i)-'0';
            for (int j=n-1;j>=0;j--){
                int digit2=num2.charAt(j)-'0';
                int pos1=i+j;
                int pos2=i+j+1;
                int sum=digit1*digit2+result[pos2];
                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}