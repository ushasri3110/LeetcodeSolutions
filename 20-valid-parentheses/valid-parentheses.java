class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (char ch:s.toCharArray()){
            if (!stack.isEmpty() && ((stack.peek()=='('&& ch==')') || (stack.peek()=='{'&& ch=='}') || (stack.peek()=='['&& ch==']'))){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}