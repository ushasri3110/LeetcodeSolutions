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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize=queue.size();
            int last=0;
            for (int i=0;i<levelSize;i++){
                TreeNode node=queue.poll();
                last=node.val;
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            res.add(last);
        }
        return res;
    }
}