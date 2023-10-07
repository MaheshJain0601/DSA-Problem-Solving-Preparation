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
    private boolean isSubtreeHelper(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return (node1 == node2);
        }

        return (
            node1.val == node2.val &&
            isSubtreeHelper(node1.left, node2.left) &&
            isSubtreeHelper(node1.right, node2.right)
        );
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return (root == subRoot);
        }

        return (
            isSubtreeHelper(root, subRoot) ||
            isSubtree(root.left, subRoot) ||
            isSubtree(root.right, subRoot)
        );
    }
}