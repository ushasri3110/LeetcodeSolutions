class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack=new Stack<>();
        Stack<String> strStack=new Stack<>();
        int num=0;
        String output="";
        for(char ch:s.toCharArray()){
            if (Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if (ch=='['){
                numStack.push(num);
                strStack.push(output);
                num=0;
                output="";
            }
            else if (ch==']'){
                int repeatCount=numStack.pop();
                String current=strStack.pop();
                for (int i=0;i<repeatCount;i++){
                    current=current+output;
                }
                output=current;
            }
            else{
                output+=ch;
            }
        }
        return output;
    }
}