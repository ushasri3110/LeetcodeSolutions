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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] preorder,int[] inorder,int inStart,int inEnd){
        if (inStart>inEnd || preIndex>=preorder.length) return null;
        int rootData=preorder[preIndex];
        TreeNode root=new TreeNode(rootData);
        preIndex++;
        int rootIndex=inStart;
        while (rootIndex<=inEnd && inorder[rootIndex]!=rootData){
            rootIndex++;
        }
        root.left=helper(preorder,inorder,inStart,rootIndex-1);
        root.right=helper(preorder,inorder,rootIndex+1,inEnd);
        return root;
    }
}