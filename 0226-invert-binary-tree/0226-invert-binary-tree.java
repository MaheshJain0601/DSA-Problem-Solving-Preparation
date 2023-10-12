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
    private void mirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        mirrorTree(root.left);
        mirrorTree(root.right);
        
        TreeNode node = root.left;
        root.left = root.right;
        
        root.right = node;
        
    }
    public TreeNode invertTree(TreeNode root) {
        mirrorTree(root);
        return root;
    }
}