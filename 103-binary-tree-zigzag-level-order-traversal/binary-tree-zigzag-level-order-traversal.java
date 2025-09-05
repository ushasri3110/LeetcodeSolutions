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
        List<List<Integer>> ans=new ArrayList<>();
        if (root==null) return ans;
        boolean isLeftToRight=true;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size=q.size();
            Deque<Integer> level=new ArrayDeque<>();
            for (int i=0;i<size;i++){
                TreeNode current=q.poll();
                if (isLeftToRight) level.addLast(current.val);
                else level.addFirst(current.val);
                if (current.left!=null) q.offer(current.left);
                if (current.right!=null) q.offer(current.right);
            }
            ans.add(new ArrayList<>(level));
            isLeftToRight=!isLeftToRight;
        }
        return ans;
    }
}