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
    public int maxDepth(TreeNode root) {
        int maxDepth=0;
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null) return 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            maxDepth++;
            int currentSize=queue.size();
            for (int i=0;i<currentSize;i++){
                TreeNode node=queue.poll();
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
        }
        return maxDepth;
    }
}