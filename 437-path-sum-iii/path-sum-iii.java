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
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null) return 0;
        return pathSumHelper(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    private int pathSumHelper(TreeNode root,long target){
        if (root==null) return 0;
        int count=0;
        if (root.val==target) count++;
        count+=pathSumHelper(root.left,target-root.val);
        count+=pathSumHelper(root.right,target-root.val);
        return count;
    }

}