/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void findParent(TreeNode root,Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode p=q.poll();
            if (p.left!=null){
                parent.put(p.left,p);
                q.offer(p.left);
            }
            if (p.right!=null){
                parent.put(p.right,p);
                q.offer(p.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        findParent(root,parent);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int currentDistance=0;
        while (!q.isEmpty()){
            int size=q.size();
            if (currentDistance==k) break;
            currentDistance++;
            for (int i=0;i<size;i++){
                TreeNode current=q.poll();
                if (current.left!=null && !visited.containsKey(current.left)){
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if (current.right!=null && !visited.containsKey(current.right)){
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                if (parent.get(current)!=null && !visited.containsKey(parent.get(current))){
                    q.offer(parent.get(current));
                    visited.put(parent.get(current),true);
                }
            }
        }
        List<Integer> result=new ArrayList<>();
        while (!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;
    }
}