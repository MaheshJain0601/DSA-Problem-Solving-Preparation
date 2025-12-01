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
    // DFS

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean isCompleteTreeHelperDFS(TreeNode root, int index, int totalNodes) {
        if (root == null) {
            return true;
        }

        if (index >= totalNodes) {
            return false;
        }
        return isCompleteTreeHelperDFS(root.left, 2*index + 1, totalNodes)
            && isCompleteTreeHelperDFS(root.right, 2*index + 2, totalNodes);
    }
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);

        int index = 0;
        return isCompleteTreeHelperDFS(root, index, totalNodes);
    }
}