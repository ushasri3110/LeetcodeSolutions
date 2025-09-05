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
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while (!q.isEmpty()){
            int size=q.size();
            int first=0;
            int last=0;
            for (int i=0;i<size;i++){
                Pair current=q.poll();
                if (i==0) first=current.index;
                if (i==size-1) last=current.index;
                if (current.node.left!=null) q.offer(new Pair(current.node.left,2*current.index+1));
                if (current.node.right!=null) q.offer(new Pair(current.node.right,2*current.index+2));
            }
            maxWidth=Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
}