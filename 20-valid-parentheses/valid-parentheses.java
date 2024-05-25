class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(char c : s.toCharArray()){
            if (!stack.isEmpty()&&map.get(c)==stack.peek()){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}