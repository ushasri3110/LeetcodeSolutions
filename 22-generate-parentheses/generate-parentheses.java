class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        parenthesisHelper("",n,0,0);
        return res;
    }
    public void parenthesisHelper(String current,int n,int opening,int closing){
        if (opening>n || closing>opening){
            return;
        }
        if (current.length()==2*n && opening == closing){
            res.add(current);
            return;
        }
        if (opening<n){
            parenthesisHelper(current+"(",n,opening+1,closing);
        }
        if (closing<n){
            parenthesisHelper(current+")",n,opening,closing+1);
        }
    }
}