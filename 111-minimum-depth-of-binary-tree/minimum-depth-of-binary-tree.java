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
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        int depth=1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int currentLevelSize=queue.size();
            for (int i=0;i<currentLevelSize;i++){
                TreeNode currentNode=queue.poll();
                if (currentNode.left==null && currentNode.right==null){
                    return depth;
                }
                if (currentNode.left!=null) queue.offer(currentNode.left);
                if (currentNode.right!=null) queue.offer(currentNode.right);
            }
            depth++;
        }
        return depth;
    }
}