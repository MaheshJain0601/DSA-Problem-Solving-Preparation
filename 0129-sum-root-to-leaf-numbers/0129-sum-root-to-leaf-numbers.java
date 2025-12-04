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
    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
    private void sumNumberHelper(TreeNode root, int currSum, int[] sumRootToLeaf) {
        if (root == null) {
            return;
        }

        if (isLeafNode(root)) {
            sumRootToLeaf[0] += (currSum*10 + root.val);
            return;
        }

        currSum = currSum*10 + root.val;

        sumNumberHelper(root.left, currSum, sumRootToLeaf);
        sumNumberHelper(root.right, currSum, sumRootToLeaf);
    }

    public int sumNumbers(TreeNode root) {
        int[] sumRootToLeaf = new int[1];
        int currSum = 0;
        sumNumberHelper(root, currSum, sumRootToLeaf);
        return sumRootToLeaf[0];
    }
}