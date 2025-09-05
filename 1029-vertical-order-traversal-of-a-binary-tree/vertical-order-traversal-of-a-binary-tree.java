/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes=new ArrayList<>();
        dfs(root,0,0,nodes);
        Collections.sort(nodes,(a,b)->{
            if (a[2]!=b[2]) return Integer.compare(a[2],b[2]);
            else if (a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        List<List<Integer>> res=new ArrayList<>();
        int prevCol=Integer.MIN_VALUE;
        for (int[] node:nodes){
            int col=node[2];
            int val=node[0];
            if (prevCol!=col){
                res.add(new ArrayList<>());
                prevCol=col;
            }
            res.get(res.size()-1).add(val);
        }
        return res;
    }
    public void dfs(TreeNode root,int row,int col,List<int[]> nodes){
        if (root==null) return;
        nodes.add(new int[]{root.val,row,col});
        dfs(root.left,row+1,col-1,nodes);
        dfs(root.right,row+1,col+1,nodes);
    }
}