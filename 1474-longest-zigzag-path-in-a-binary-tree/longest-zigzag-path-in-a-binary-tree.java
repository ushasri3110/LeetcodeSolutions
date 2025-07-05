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
    int maxLength=0;
    public int longestZigZag(TreeNode root) {
        dfs(root.left,1,true);
        dfs(root.right,1,false);
        return maxLength;
    }
    public void dfs(TreeNode root,int length,boolean isLeft){
        if (root==null) return;
        maxLength=Math.max(maxLength,length);
        if (isLeft){
            dfs(root.right,length+1,false);
            dfs(root.left,1,true);
        }
        else{
            dfs(root.left,length+1,true);
            dfs(root.right,1,false);
        }
    }
}