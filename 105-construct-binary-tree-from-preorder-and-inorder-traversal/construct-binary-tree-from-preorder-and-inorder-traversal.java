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
        return buildTreeHelper(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] preorder,int[] inorder,int inStart,int inEnd){
        if (inStart>inEnd) return null;
        int rootVal=preorder[preIndex++];
        TreeNode root=new TreeNode(rootVal);
        int inIndex=0;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==rootVal){
                inIndex=i;
                break;
            }
        }
        root.left=buildTreeHelper(preorder,inorder,inStart,inIndex-1);
        root.right=buildTreeHelper(preorder,inorder,inIndex+1,inEnd);
        return root;
    }
}