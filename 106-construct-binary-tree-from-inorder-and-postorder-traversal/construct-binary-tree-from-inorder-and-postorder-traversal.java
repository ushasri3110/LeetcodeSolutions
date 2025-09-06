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
        return buildTreeHelper(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] inorder,int[] postorder,int inStart,int inEnd){
        if (inStart>inEnd) return null;
        int rootVal=postorder[postIndex--];
        TreeNode root=new TreeNode(rootVal);
        int inIndex=0;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==rootVal){
                inIndex=i;
                break;
            }
        }
        root.right=buildTreeHelper(inorder,postorder,inIndex+1,inEnd);
        root.left=buildTreeHelper(inorder,postorder,inStart,inIndex-1);
        return root;
    }
}