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
    public void postorderTraversalHelper(TreeNode root,List<Integer> output){
        if (root==null){
            return;
        }
        postorderTraversalHelper(root.left,output);
        postorderTraversalHelper(root.right,output);
        output.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output=new ArrayList<>();
        postorderTraversalHelper(root,output);
        return output;
    }
}