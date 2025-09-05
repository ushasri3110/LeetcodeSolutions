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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans=new int[1];
        diameter(root,ans);
        return ans[0];
    }
    public int diameter(TreeNode root,int[] d){
        if (root==null) return 0;
        int lh=diameter(root.left,d);
        int rh=diameter(root.right,d);
        d[0]=Math.max(d[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
}