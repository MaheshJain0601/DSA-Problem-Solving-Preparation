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
    // Approach-1
    private void longestZigZagHelper(TreeNode root, int steps, int[] maxPath, boolean goLeft) {
        if (root == null) return;

        maxPath[0] = Math.max(maxPath[0], steps);

        // If the ask is to go left
        if (goLeft) {
            // either I'll follow the rule, which will reward i.e., prevStep + 1
            // Next move will not be goLeft (as we want zig-zag)
            longestZigZagHelper(root.left, steps + 1, maxPath, !goLeft);

            // If I don't follow the rule, I start from the begining i.e., step = 1
            // Next move will be goLeft (as we want zig-zag)
            longestZigZagHelper(root.right, 1, maxPath, goLeft);
        } else { // If the ask is to go right
            
            // either I'll follow the rule, which will reward i.e., prevStep + 1
            // Next move will not be goLeft (as we want zig-zag)
            longestZigZagHelper(root.right, steps + 1, maxPath, !goLeft);

            // If I don't follow the rule, I start from the begining i.e., step = 1
            // Next move will be not go left (as we want zig-zag)
            longestZigZagHelper(root.left, 1, maxPath, goLeft);
        }
    }
    public int longestZigZagApproach1(TreeNode root) {
        int[] maxPath = new int[1];
        maxPath[0] = 0;
        longestZigZagHelper(root, 0, maxPath, true);
        longestZigZagHelper(root, 0, maxPath, false);
        return maxPath[0];
    }

    // Approach-2
    private void helperLongestZigZag(TreeNode root, int leftPath, int rightPath, int[] maxPath) {
        if (root == null) return;

        maxPath[0] = Math.max(maxPath[0], leftPath);
        maxPath[0] = Math.max(maxPath[0], rightPath);

        helperLongestZigZag(root.left, rightPath + 1, 0, maxPath);
        helperLongestZigZag(root.right, 0, leftPath + 1, maxPath);
    }
    public int longestZigZag(TreeNode root) {
        int[] maxPath = new int[1];
        maxPath[0] = 0;
        helperLongestZigZag(root, 0, 0, maxPath);
        return maxPath[0];
    }
}