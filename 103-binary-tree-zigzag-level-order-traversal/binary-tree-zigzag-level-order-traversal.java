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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean flag=false;
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> level=new ArrayList<>();
            Stack<Integer> stack=new Stack<>();
            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if (flag) stack.add(node.val);
                else level.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            flag=!flag;
            while (!stack.isEmpty()) level.add(stack.pop());
            res.add(level);
        }
        return res;
    }
}