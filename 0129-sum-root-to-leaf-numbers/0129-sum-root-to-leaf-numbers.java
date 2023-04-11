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
    void sumRootToLeaf(TreeNode root, int[] result, int value) {
        if (root == null) {
            return;
        }
        
        value = (value*10) + root.val;
        
        if (root.left == null && root.right == null) {
            result[0] += value;
            return;
        }
        
        sumRootToLeaf(root.left, result, value);
        sumRootToLeaf(root.right, result, value);
    }
    public int sumNumbers(TreeNode root) {
        int[] result = new int[1];
        result[0] = 0;
        sumRootToLeaf(root, result, 0);
        
        return result[0];
    }
}