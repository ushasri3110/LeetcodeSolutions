class Solution {
    public String decodeString(String s) {
        Stack<Integer> integerStack=new Stack<>();
        Stack<StringBuilder> stringStack=new Stack<>();
        StringBuilder current=new StringBuilder();
        int k=0;
        for (char ch:s.toCharArray()){
            if (Character.isDigit(ch)){
                k=k*10+(ch-'0');
            }
            else if (ch=='['){
                integerStack.push(k);
                k=0;
                stringStack.push(current);
                current=new StringBuilder();
            }
            else if (ch==']'){
                StringBuilder str=stringStack.pop();
                int count=integerStack.pop();
                for (int i=0;i<count;i++){
                    str.append(current);
                }
                current=str;
            }
            else{
                current.append(ch);
            }
        }
        return current.toString();
    }
}