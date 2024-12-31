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
    public int maxLevelSum(TreeNode root) {
        if (root==null){
            return 0;
        }
        int maxSum=Integer.MIN_VALUE;
        int res=0;
        int currentLevel=1;
        List<TreeNode> level=new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()){
            List<TreeNode> nextLevel=new ArrayList<>();
            int currentSum=0;
            for(TreeNode node:level){
                currentSum+=node.val;
                if(node.left!=null){
                    nextLevel.add(node.left);
                }
                if (node.right!=null){
                    nextLevel.add(node.right);
                }
            }
            if (currentSum>maxSum){
                maxSum=currentSum;
                res=currentLevel;
            }
            level=nextLevel;
            currentLevel++;
        }
        return res;
    }
}