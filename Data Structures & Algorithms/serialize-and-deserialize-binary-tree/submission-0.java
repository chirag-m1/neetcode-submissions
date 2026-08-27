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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("n ");
                continue;
            }
            else {
                sb.append(node.val + " ");
            }
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "" || data.startsWith("n")) return null;
        Queue<TreeNode> q = new LinkedList<>();

        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);

        for(int i = 1; i < nodes.length; i++) {
            TreeNode parent = q.poll();
            if(!nodes[i].equals("n")) {
                TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = node;
                q.add(node);
            }
            if(!nodes[++i].equals("n")) {
                TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = node;
                q.add(node);
            }
        }
        return root;
    }
}
