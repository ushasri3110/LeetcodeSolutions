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
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        List<TreeNode> levelList = new ArrayList<>();
        levelList.add(root);

        while (!levelList.isEmpty()) {
            result.add(levelList.get(levelList.size() - 1).val);

            List<TreeNode> nextLevelList = new ArrayList<>();
            for (TreeNode node : levelList) {
                if (node.left != null) nextLevelList.add(node.left);
                if (node.right != null) nextLevelList.add(node.right);
            }
            levelList = nextLevelList;
        }

        return result;
    }
}