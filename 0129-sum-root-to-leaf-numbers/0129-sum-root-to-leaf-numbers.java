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
    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
    private void sumNumberHelper(TreeNode root, int[] sumRootToLeaf, int currSum) {
        if (root == null) {
            return;
        }
        
        currSum = (currSum * 10) + root.val;
        if (isLeafNode(root)) {
            sumRootToLeaf[0] += currSum;
            return;
        }
        
        sumNumberHelper(root.left, sumRootToLeaf, currSum);
        sumNumberHelper(root.right, sumRootToLeaf, currSum);
        return;
    }

    public int sumNumbers(TreeNode root) {
        int[] sumRootToLeaf = new int[1];
        int currSum = 0;
        sumNumberHelper(root, sumRootToLeaf, currSum);
        return sumRootToLeaf[0];
    }
}