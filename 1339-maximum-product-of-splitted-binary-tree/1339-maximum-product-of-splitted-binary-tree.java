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
    public static final double MOD = 10e8 + 7;
    private long totalSum(TreeNode root) {
        if (root == null) return 0L;

        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    private long findMaxProductSplittedBinaryTree(TreeNode root, long totalTreeSum, long[] maxProduct) {
        if (root == null) return 0L;

        long leftSubTreeSum = findMaxProductSplittedBinaryTree(root.left, totalTreeSum, maxProduct);
        long rightSubTreeSum = findMaxProductSplittedBinaryTree(root.right, totalTreeSum, maxProduct);

        long currSubtreeSum = root.val + leftSubTreeSum + rightSubTreeSum;
        long remainingSubtreeSum = totalTreeSum - currSubtreeSum;

        maxProduct[0] = Math.max(maxProduct[0], currSubtreeSum * remainingSubtreeSum);
        return currSubtreeSum;
    }

    public int maxProduct(TreeNode root) {
        long totalTreeSum = totalSum(root);

        long[] maxProduct = new long[1];
        findMaxProductSplittedBinaryTree(root, totalTreeSum, maxProduct);
        return (int)(maxProduct[0] % MOD);
    }
}