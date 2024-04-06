class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String output = ""; 
        int num = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); 
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(output);
                output = ""; 
                num = 0;
            } else if (ch == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int repeatTimes = numStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(output);
                }
                output=sb.toString(); 
            } else {
                output+=ch; 
            }
        }
        return output;
    }
}