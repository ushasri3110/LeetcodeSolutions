class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if (n%2==1){
            return false;
        }
        Stack<Integer> unlocked=new Stack<>();
        Stack<Integer> openBrackets=new Stack<>();
        for (int i=0;i<n;i++){
            if (locked.charAt(i)=='0'){
                unlocked.push(i);
            }
            else if (s.charAt(i)=='('){
                openBrackets.push(i);
            }
            else if (s.charAt(i)==')'){
                if (!openBrackets.isEmpty()){
                    openBrackets.pop();
                }
                else if (!unlocked.isEmpty()){
                    unlocked.pop();
                }
                else{
                    return false;
                }
            }
        }
        while (!openBrackets.isEmpty() && !unlocked.isEmpty() && unlocked.peek()>openBrackets.peek()){
            openBrackets.pop();
            unlocked.pop();
        }
        if (!openBrackets.isEmpty()){
            return false;
        }
        return true;

    }
}