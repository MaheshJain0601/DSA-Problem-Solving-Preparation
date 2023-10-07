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
    private void dfsTraversal(TreeNode root, int[] result) {
        if (root == null) {
            return;
        }

        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    result[0] += root.left.left.val;
                }
                if (root.left.right != null) {
                    result[0] += root.left.right.val;
                }
            }

            if (root.right != null) {
                if (root.right.left != null) {
                    result[0] += root.right.left.val;
                }
                if (root.right.right != null) {
                    result[0] += root.right.right.val;
                }
            }
        }

        dfsTraversal(root.left, result);
        dfsTraversal(root.right, result);
    }
    public int sumEvenGrandparent(TreeNode root) {
        int[] result = new int[1];

        result[0] = 0;
        dfsTraversal(root, result);
        return result[0];
    }
}