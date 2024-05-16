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
    static int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex=0;
        return buildTreeHelper(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] preorder,int[] inorder,int inStart,int inEnd){
        if (inStart>inEnd || preorderIndex>=preorder.length){
            return null;
        }
        int rootData=preorder[preorderIndex];
        TreeNode root=new TreeNode(rootData);
        preorderIndex++;
        int rootIndexInInorder=inStart;
        while (inorder[rootIndexInInorder]!=rootData && rootIndexInInorder<=inEnd){
            rootIndexInInorder++;
        }
        root.left=buildTreeHelper(preorder,inorder,inStart,rootIndexInInorder-1);
        root.right=buildTreeHelper(preorder,inorder,rootIndexInInorder+1,inEnd);
        return root;
    }
}