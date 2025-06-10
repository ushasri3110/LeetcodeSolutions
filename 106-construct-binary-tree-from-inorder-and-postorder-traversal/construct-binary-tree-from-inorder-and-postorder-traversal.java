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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        return helper(inorder,postorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] inorder,int[] postorder,int inStart,int inEnd){
        if (inStart>inEnd || postIndex<0) return null;
        int rootData=postorder[postIndex];
        postIndex--;
        TreeNode root=new TreeNode(rootData);
        int rootIndex=inStart;
        while (inorder[rootIndex]!=rootData && rootIndex<=inEnd){
            rootIndex++;
        }
        root.right=helper(inorder,postorder,rootIndex+1,inEnd);
        root.left=helper(inorder,postorder,inStart,rootIndex-1);
        return root;
    }
}