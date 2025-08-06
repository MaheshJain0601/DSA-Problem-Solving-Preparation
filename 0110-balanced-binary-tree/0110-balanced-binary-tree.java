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
    public int isBalancedTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalancedTreeHeight(root.left);
        if (leftHeight == -1) {
            // Not a balanced binary tree, no need to check further
            return -1;
        }
        int rightHeight = isBalancedTreeHeight(root.right);
        if (rightHeight == -1) {
            // Not a balanced binary tree, no need to check further
            return -1;
        }

        if (Math.abs(rightHeight - leftHeight) > 1) {
            // Not a balanced binary tree, given height difference is > 1
            return -1;
        }
        
        // Compute height of the tree at currentNode
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHeight(root) != -1;
    }
}