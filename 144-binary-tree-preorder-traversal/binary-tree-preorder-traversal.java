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
    public void preorderTraversalHelper(TreeNode root,List<Integer> output){
        if (root==null){
            return;
        }
        output.add(root.val);
        preorderTraversalHelper(root.left,output);
        preorderTraversalHelper(root.right,output);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output=new ArrayList<>();
        preorderTraversalHelper(root,output);
        return output;
    }
}