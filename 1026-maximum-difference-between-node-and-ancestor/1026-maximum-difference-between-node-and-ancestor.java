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
    private int maximumAncestorDifference(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return Math.abs(maxValue - minValue);
        }
        
        maxValue = Math.max(maxValue, root.val);
        minValue = Math.min(minValue, root.val);
        
        int leftMax = maximumAncestorDifference(root.left, minValue, maxValue);
        int rightMax = maximumAncestorDifference(root.right, minValue, maxValue);
        
        return Math.max(leftMax, rightMax);
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return maximumAncestorDifference(root, root.val, root.val);
    }
}