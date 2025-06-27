class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode(){
        children=new TrieNode[26];
        isEndOfWord=false;
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root=new TrieNode();
        Arrays.sort(products);
        for (String product:products){
            insertWord(root,product);
        }
        List<List<String>> res=new ArrayList<>();
        boolean noMatch=false;
        StringBuilder sb=new StringBuilder();
        TrieNode node=root;
        for (char ch:searchWord.toCharArray()){
            sb.append(ch);
            if (!noMatch){
                int index=ch-'a';
                if (node!=null) node=node.children[index];
                if (node==null) {
                    noMatch=true;
                    res.add(new ArrayList<>());
                }
                else{
                    List<String> suggestions=new ArrayList<>();
                    dfs(node,sb.toString(),suggestions);
                    res.add(suggestions);
                }
            }
            else{
                res.add(new ArrayList<>());
            }
        }
        return res;
    }
    private void insertWord(TrieNode root,String word){
        TrieNode current=root;
        for (char ch:word.toCharArray()){
            int index=ch-'a';
            if (current.children[index]==null) current.children[index]=new TrieNode();
            current=current.children[index];
        }
        current.isEndOfWord=true;
    }
    private void dfs(TrieNode node,String prefix,List<String> suggestions){
        if (suggestions.size()==3 || node==null) return;
        if (node.isEndOfWord) suggestions.add(prefix);
        for (int i=0;i<26;i++){
            if (node.children[i]!=null){
                dfs(node.children[i],prefix+(char)('a'+i),suggestions);
            }
        }
    }
    
}