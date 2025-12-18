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
    // Approach-1: Extra space using array
    private boolean isLeafNode(TreeNode node) {
        if (node == null) return false;

        return node.left == null && node.right == null;
    }

    private boolean isPseudoPalindromic(int[] nodeFrequency) {
        int oldFreqElements = 0;
        for (int freq: nodeFrequency) {
            if (freq % 2 == 1)
                oldFreqElements++;
            
            if (oldFreqElements > 1) {
                return false;
            }
        }
        return true;
    }
    private void pseudoPalindromicPathsHelper(TreeNode root, int[] nodeFrequency, int[] result) {
        if (root == null) return;

        nodeFrequency[root.val] += 1;
        if (isLeafNode(root)) {
            result[0] += isPseudoPalindromic(nodeFrequency) ? 1 : 0;
        }

        pseudoPalindromicPathsHelper(root.left, nodeFrequency, result);
        pseudoPalindromicPathsHelper(root.right, nodeFrequency, result);

        nodeFrequency[root.val] -= 1;
    }
    public int pseudoPalindromicPathsArray (TreeNode root) {
        int[] result = new int[1];
        result[0] = 0;

        int[] nodeFrequency = new int[10];

        pseudoPalindromicPathsHelper(root, nodeFrequency, result);

        return result[0];
    }

    // Approach-2: Extra space using just an integer: bit operations

    private void pseudoPalindromicPathsHelperBitWise(TreeNode root, int value, int[] result) {
        if (root == null) return;

        value = value ^ (1 << root.val);
        if (isLeafNode(root)) {
            result[0] += (value & (value - 1)) == 0 ? 1 : 0;
        }

        pseudoPalindromicPathsHelperBitWise(root.left, value, result);
        pseudoPalindromicPathsHelperBitWise(root.right, value, result);
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] result = new int[1];
        result[0] = 0;

        pseudoPalindromicPathsHelperBitWise(root, 0, result);

        return result[0];
    }
}