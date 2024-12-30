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
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root,Integer.MIN_VALUE);
    }
    public int goodNodesHelper(TreeNode root,int max_value){
        int count=0;
        if(root.val>=max_value){
            count++;
        }
        if(root.left!=null){
            count+=goodNodesHelper(root.left,Math.max(max_value,root.val));
        }
        if(root.right!=null){
            count+=goodNodesHelper(root.right,Math.max(max_value,root.val));
        }
        return count;
    }
}