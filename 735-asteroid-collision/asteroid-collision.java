class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        for (int i:asteroids){
            boolean isDestroyed=false;
            while (!s.isEmpty() && (s.peek()>0 && i<0)){
                int top=s.peek();
                if (Math.abs(i)>top){
                    s.pop();
                }
                else if (Math.abs(i)==top){
                    isDestroyed=true;
                    s.pop();
                    break;
                }
                else{
                    isDestroyed=true;
                    break;
                }
            }
            if (!isDestroyed) s.push(i);
        }
        int[] res=new int[s.size()];
        for (int i=s.size()-1;i>=0;i--) res[i]=s.pop();
        return res;
    }
}