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
    public int rob(TreeNode root) {
        int[] options=traverse(root);
        return Math.max(options[0],options[1]);
    }
    public int[] traverse(TreeNode root){
        if (root==null){
            return new int[2];
        }
        int[] leftNodeChoices=traverse(root.left);
        int[] rightNodeChoices=traverse(root.right);
        int[] options=new int[2];
        //looted stored in 0
        options[0]=root.val+leftNodeChoices[1]+rightNodeChoices[1];
        //skipped stored in 1
        options[1]=Math.max(leftNodeChoices[0],leftNodeChoices[1])+Math.max(rightNodeChoices[0],rightNodeChoices[1]);
        return options;
    }
}