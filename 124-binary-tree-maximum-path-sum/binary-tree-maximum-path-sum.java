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
    int maxValue=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;
    }
    private int dfs(TreeNode root){
        if (root==null) return 0;
        int maxLeft=Math.max(0,dfs(root.left));
        int maxRight=Math.max(0,dfs(root.right));
        maxValue=Math.max(maxValue,maxLeft+maxRight+root.val);
        return root.val+Math.max(maxLeft,maxRight);
    }
}