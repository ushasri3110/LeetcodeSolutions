class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        partitionHelper(0,s,new ArrayList<>(),res);
        return res;
    }
    private void partitionHelper(int idx,String s,List<String> path,List<List<String>> res){
        if (idx==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=idx;i<s.length();i++){
            if (isPalindrome(s,idx,i)){
                path.add(s.substring(idx,i+1));
                partitionHelper(i+1,s,path,res);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int start,int end){
        while (start<=end){
            if (s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}