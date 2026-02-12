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
    long minimumValue = Long.MAX_VALUE;
    long secondMinimumValue = Long.MAX_VALUE;
    public void findSecondMinimumValueHelper(TreeNode root) {
        if (root == null) return;

        if (root.val < minimumValue) {
            secondMinimumValue = minimumValue;
            minimumValue = root.val;
        } else if (root.val < secondMinimumValue && root.val != minimumValue) {
            secondMinimumValue = root.val;
        }


        findSecondMinimumValueHelper(root.left);
        findSecondMinimumValueHelper(root.right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        findSecondMinimumValueHelper(root);
        return (int) secondMinimumValue;
    }
}