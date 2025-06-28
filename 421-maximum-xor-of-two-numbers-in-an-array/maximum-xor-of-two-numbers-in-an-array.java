class TrieNode{
    TrieNode[] children=new TrieNode[2];
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root=new TrieNode();
        int maxXOR=0;
        for (int num:nums){
            insert(root,num);
        }
        for (int num:nums){
            int xor=findMaximum(root,num);
            maxXOR=Math.max(xor,maxXOR);
        }
        return maxXOR;
    }
    private int findMaximum(TrieNode root,int num){
        TrieNode current=root;
        int sum=0;
        for (int i=31;i>=0;i--){
            int currBit=(num>>i) & 1;
            if (current.children[currBit^1]!=null){
                sum+=(1<<i);
                current=current.children[currBit^1];
            }
            else{
                current=current.children[currBit];
            }
            
        }
        return sum;
    }
    private void insert(TrieNode root,int num){
        TrieNode current=root;
        for (int i=31;i>=0;i--){
            int bit= (num>>i) & 1;
            if (current.children[bit]==null) current.children[bit]=new TrieNode();
            current=current.children[bit];
        }
    }
}