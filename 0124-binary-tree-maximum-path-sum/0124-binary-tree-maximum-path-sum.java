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
    private int findMaxPathSumRecursive(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, findMaxPathSumRecursive(root.left, maxSum));
        int rightSum = Math.max(0, findMaxPathSumRecursive(root.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + root.val);


        return root.val + Math.max(leftSum, rightSum);
    }
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        
        maxSum[0] = Integer.MIN_VALUE;
        findMaxPathSumRecursive(root, maxSum);
        return maxSum[0];
    }
}