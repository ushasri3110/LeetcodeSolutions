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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        inorderHelper(root,result);
        return result;
    }
    public void inorderHelper(TreeNode root,List<Integer> result){
        if (root==null){
            return;
        }
        inorderHelper(root.left,result);
        result.add(root.val);
        inorderHelper(root.right,result);
    }
}