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
        if (root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        int ans=0;
        while (!q.isEmpty()){
            int size=q.size();
            int first=0;
            int last=0;
            for (int i=0;i<size;i++){
                TreeNode front=q.peek().node;
                int curIndex=q.peek().index;
                q.poll();
                if (i == 0) first = curIndex;
                if (i == size - 1) last = curIndex;
                if (front.left!=null) q.offer(new Pair(front.left,2*curIndex+1));
                if (front.right!=null) q.offer(new Pair(front.right,2*curIndex+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
