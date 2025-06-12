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
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int leftHeight=height(root,true);
        int rightHeight=height(root,false);
        if (leftHeight==rightHeight){
            return (1<<leftHeight)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int height(TreeNode node,boolean isLeft){
        int height=0;
        while(node!=null){
            height++;
            node=isLeft?node.left:node.right;
        }
        return height;
    }
}