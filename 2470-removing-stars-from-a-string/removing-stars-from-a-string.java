class Solution {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();
        String str="";
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)!='*'){
                stack.push(s.charAt(i));
            }
            else{
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()){
            str=stack.pop()+str;
        }
        return str;
        
    }
}