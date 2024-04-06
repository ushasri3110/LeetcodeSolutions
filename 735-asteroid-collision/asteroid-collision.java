class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<Integer>();
        for (int i:asteroids){
            boolean flag=true;
            while(!stack.isEmpty()&&i<0&&stack.peek()>0){
                if (-i>stack.peek()){
                    stack.pop();
                }
                else if (-i<stack.peek()){
                   flag=false;
                   break;
                }
                else if (-i==stack.peek()){
                    flag=false;
                    stack.pop();
                    break;
                }
            }
            if (flag){
                stack.push(i);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}