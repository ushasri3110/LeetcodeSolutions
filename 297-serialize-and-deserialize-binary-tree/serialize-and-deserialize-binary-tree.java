/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node=q.poll();
            if (node==null){
                sb.append("null ");
                continue;
            }
            sb.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()<1) return null;
        String[] values=data.split(" ");
        Queue<TreeNode> q=new LinkedList<>();
        Integer rootData=Integer.parseInt(values[0]);
        TreeNode root=new TreeNode(rootData);
        q.offer(root);
        int i=1;
        while (!q.isEmpty()){
            TreeNode node=q.poll();
            if (!values[i].equals("null")){
                TreeNode leftNode=new TreeNode(Integer.parseInt(values[i]));
                node.left=leftNode;
                q.offer(leftNode);
            }
            i++;
            if (!values[i].equals("null")){
                TreeNode rightNode=new TreeNode(Integer.parseInt(values[i]));
                node.right=rightNode;
                q.offer(rightNode);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));