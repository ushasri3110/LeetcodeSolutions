class TrieNode{
    TrieNode[] children;
    TrieNode(){
        children=new TrieNode[2];
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n=queries.length;
        int[] result=new int[n];
        int[][] extendedQueries=new int[n][3];
        for (int i=0;i<n;i++){
            extendedQueries[i][0]=queries[i][0];
            extendedQueries[i][1]=queries[i][1];
            extendedQueries[i][2]=i;
        }
        Arrays.sort(extendedQueries,Comparator.comparingInt(a->a[1]));
        int index=0;
        TrieNode root=new TrieNode();
        for (int[] query:extendedQueries){
            int x=query[0];
            int m=query[1];
            int id=query[2];
            while (index<nums.length && nums[index]<=m){
                insert(root,nums[index]);
                index++;
            }
            if (index==0){
                result[id]=-1;
            }
            else{
                result[id]=findMaximumXor(root,x);
            }
        }
        return result;
    }
    private void insert(TrieNode root,int num){
        TrieNode current=root;
        for (int i=31;i>=0;i--){
            int bit=(num>>i) & 1;
            if (current.children[bit]==null) current.children[bit]=new TrieNode();
            current=current.children[bit];
        }
    }
    private int findMaximumXor(TrieNode root,int num){
        TrieNode current=root;
        int res=0;
        for (int i=31;i>=0;i--){
            int bit = (num >> i) & 1;
            if (current.children[bit^1]!=null){
                res+=1<<i;
                current=current.children[bit^1];
            }
            else{
                current=current.children[bit];
            }
        }
        return res;
    }
}