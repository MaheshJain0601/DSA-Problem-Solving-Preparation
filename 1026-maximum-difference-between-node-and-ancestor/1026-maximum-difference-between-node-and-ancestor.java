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
    // Brute force
    // TC: O(N^2)
    private void findMaxDiffHelper(TreeNode root, TreeNode child, int[] maxDiff) {
        if (root == null || child == null) return;

        maxDiff[0] = Math.max(maxDiff[0], Math.abs(root.val - child.val));

        findMaxDiffHelper(root, child.left, maxDiff);
        findMaxDiffHelper(root, child.right, maxDiff);
    }

    private void findMaxDiff(TreeNode root, int[] maxDiff) {
        if (root == null) return;

        findMaxDiffHelper(root, root.left, maxDiff);
        findMaxDiffHelper(root, root.right, maxDiff);

        findMaxDiff(root.left, maxDiff);
        findMaxDiff(root.right, maxDiff);

    }
    public int maxAncestorDiffBruteForce(TreeNode root) {
        int[] maxDiff = new int[1];
        findMaxDiff(root, maxDiff);
        return maxDiff[0];
    }

    // Optimised
    private int maxAncestorDiffHelper(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return Math.abs(maxValue - minValue);
        }

        minValue = Math.min(minValue, root.val);
        maxValue = Math.max(maxValue, root.val);

        int leftMax = maxAncestorDiffHelper(root.left, minValue, maxValue);
        int rightMax = maxAncestorDiffHelper(root.right, minValue, maxValue);

        return Math.max(leftMax, rightMax);
    }

    public int maxAncestorDiff(TreeNode root) {
        // int[] maxDiff = new int[1];
        return maxAncestorDiffHelper(root, root.val, root.val);
        // return maxDiff[0];
    }
}