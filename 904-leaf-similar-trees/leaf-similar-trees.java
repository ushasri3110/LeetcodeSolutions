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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> L1=new ArrayList<>();
        List<Integer> L2=new ArrayList<>();
        leafNodes(root1,L1);
        leafNodes(root2,L2);
        return L1.equals(L2);
    }
    public void leafNodes(TreeNode root,List<Integer> L){
        if (root==null){
            return;
        }
        if (root.left==null && root.right==null){
            L.add(root.val);
        }
        leafNodes(root.left,L);
        leafNodes(root.right,L);
    }
}