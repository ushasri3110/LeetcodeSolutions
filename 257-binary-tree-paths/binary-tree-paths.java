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
    public List<String> result=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        pathHelper(root,new StringBuilder());
        return result;
    }
    public void pathHelper(TreeNode root,StringBuilder sb){
        if (root==null){
            return;
        }
        int length = sb.length();
        if (root.left==null && root.right==null){
            sb.append(root.val);
            result.add(sb.toString());
        }
        else{
            sb.append(root.val);
            sb.append("->");
        }
        pathHelper(root.left,sb);
        pathHelper(root.right,sb);
        sb.setLength(length); 
    }
}