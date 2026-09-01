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
    int countGoodNodes(TreeNode root, int maxVal) {
        if(root == null) return 0;
        int count = root.val >= maxVal ? 1 : 0;

        maxVal = Math.max(maxVal, root.val);
        return count + countGoodNodes(root.left, maxVal) + countGoodNodes(root.right, maxVal);
    }
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
}
