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
    private int distributeCoinsHelper(TreeNode root, int[] moves) {
        if (root == null) return 0;

        int leftExtraCoins = distributeCoinsHelper(root.left, moves);
        int rightExtraCoins = distributeCoinsHelper(root.right, moves);

        moves[0] += (Math.abs(leftExtraCoins) + Math.abs(rightExtraCoins));

        // Total coins - 1
        return (leftExtraCoins + rightExtraCoins + root.val) - 1;
    }
    public int distributeCoins(TreeNode root) {
        int[] moves = new int[1];
        moves[0] = 0;

        distributeCoinsHelper(root, moves);

        return moves[0];
    }
}