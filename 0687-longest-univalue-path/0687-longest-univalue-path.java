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
    int maxLength = 0;
    private int longestUnivaluePathHelper(TreeNode root, int parentValue) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = longestUnivaluePathHelper(root.left, root.val);
        int rightHeight = longestUnivaluePathHelper(root.right, root.val);
        
        
        maxLength = Math.max(maxLength, leftHeight + rightHeight);
        
        if (root.val == parentValue) {
            return 1 + Math.max(leftHeight, rightHeight);
        }
        
        return 0;
    }
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        maxLength = 0;
        
        longestUnivaluePathHelper(root, Integer.MIN_VALUE);
        
        return maxLength;
    }
}