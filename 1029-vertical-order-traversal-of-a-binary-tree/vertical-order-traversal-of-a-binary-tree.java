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
    List<int[]> list=new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        preorder(root,0,0);
        Collections.sort(list, (a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (int[] node : list) {
            if (node[2] != prevCol) {
                res.add(new ArrayList<>());
                prevCol = node[2];
            }
            res.get(res.size() - 1).add(node[0]);
        }
        return res;
    }
    public void preorder(TreeNode root,int row,int col){
        if (root==null) return;
        list.add(new int[]{root.val,row,col});
        preorder(root.left,row+1,col-1);
        preorder(root.right,row+1,col+1);
    }
}