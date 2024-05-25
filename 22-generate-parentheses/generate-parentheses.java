class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        if (n==0){
            return ans;
        }
        generateParenthesisHelper(n,0,0,"",ans);
        return ans;
    }
    public void generateParenthesisHelper(int n,int open,int close,String s,List<String> ans){
        if(open>n||close>open){
            return;
        }
        if (s.length()==n*2&&open==close){
            ans.add(s);
            return;
        }
        if (open<n){
            generateParenthesisHelper(n,open+1,close,s+'(',ans);
        }
        if (close<open){
            generateParenthesisHelper(n,open,close+1,s+')',ans);
        }
    }
}