class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1=helper(s);
        Stack<Character> stack2=helper(t);
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if (stack1.peek()==stack2.peek()){
                stack1.pop();
                stack2.pop();
            }
            else{
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public Stack<Character> helper(String s){
        Stack<Character> stack=new Stack<>();
        int i=0;
        while(i<s.length()){
            if (s.charAt(i)=='#'){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(s.charAt(i));
            }
            i++;
        }
        return stack;
    }
}