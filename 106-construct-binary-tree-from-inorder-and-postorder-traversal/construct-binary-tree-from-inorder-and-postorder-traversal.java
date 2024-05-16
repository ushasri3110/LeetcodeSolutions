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
    static int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex=postorder.length-1;
        return buildTreeHelper(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] inorder,int[] postorder,int start,int end){
        if (start>end || postorderIndex<0){
            return null;
        }
        int rootData=postorder[postorderIndex];
        postorderIndex--;
        TreeNode root=new TreeNode(rootData);
        int rootIndexInInorder=start;
        while(inorder[rootIndexInInorder]!=rootData && rootIndexInInorder<=end){
            rootIndexInInorder++;
        }
        root.right=buildTreeHelper(inorder,postorder,rootIndexInInorder+1,end);
        root.left=buildTreeHelper(inorder,postorder,start,rootIndexInInorder-1);
        return root;
    }
}