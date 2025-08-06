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
    private int maximumPathSum(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int leftMaxSum = Math.max(0, maximumPathSum(root.left, maxSum));
        int rightMaxSum = Math.max(0, maximumPathSum(root.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], root.val + leftMaxSum + rightMaxSum);

        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maximumPathSum(root, maxSum);
        return maxSum[0];
    }
}