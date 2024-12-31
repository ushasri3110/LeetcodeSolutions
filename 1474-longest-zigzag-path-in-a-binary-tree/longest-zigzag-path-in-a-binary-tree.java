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
    int maxZigZag=0;
    public int longestZigZag(TreeNode root) {
        if (root==null){
            return 0;
        }
        helper(root.left,1,true);
        helper(root.right,1,false);
        return maxZigZag;
    }
    public void helper(TreeNode root,int length,boolean isLeft){
        if(root==null){
            maxZigZag=Math.max(maxZigZag,length-1);
            return;
        }
        if (isLeft){
            helper(root.left,1,true);
            helper(root.right,length+1,false);
        }
        else{
            helper(root.right,1,false);
            helper(root.left,length+1,true);
        }
    }
}