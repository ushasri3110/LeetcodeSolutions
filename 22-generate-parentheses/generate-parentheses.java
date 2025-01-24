class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n==0){
            return new ArrayList<>();
        }
        generate(n,0,0,"");
        return res;
    }
    public void generate(int n,int open,int close,String currentString){
        if (open>n || close>open){
            return;
        }
        if (currentString.length()==n*2 && open==close){
            res.add(currentString);
            return;
        }
        if (open<n){
            generate(n,open+1,close,currentString+'(');
        }
        if (close<n){
            generate(n,open,close+1,currentString+')');
        }
        
    }
}