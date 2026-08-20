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
    void rightSideDFS(TreeNode root, ArrayList<Integer> ans, int level) {
        if(root == null) return;
        if(ans.size() == level) {
            ans.add(root.val);
        }
        rightSideDFS(root.right, ans, level + 1);
        rightSideDFS(root.left, ans, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        rightSideDFS(root, ans, 0);
        return ans;
    }
}
