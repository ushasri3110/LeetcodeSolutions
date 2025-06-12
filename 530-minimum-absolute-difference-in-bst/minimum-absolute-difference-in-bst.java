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
    int minDifference=Integer.MAX_VALUE;
    Integer prev=null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDifference;
    }
    private void inorder(TreeNode root){
        if (root==null) return;
        inorder(root.left);
        if (prev!=null){
            minDifference=Math.min(Math.abs(root.val-prev),minDifference);
        }
        prev=root.val;
        inorder(root.right);
    }
}