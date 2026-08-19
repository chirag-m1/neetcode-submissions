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
    int diam;
    int findDiam(TreeNode root) {
        if(root == null) return 0;
        int lh = findDiam(root.left);
        int rh = findDiam(root.right);
        diam = Math.max(diam, lh + rh);
        return 1 + Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diam = 0;
        findDiam(root);
        return diam;
    }
}
