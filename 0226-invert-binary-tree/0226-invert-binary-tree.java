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
    // Post order process
    public void mirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        mirrorTree(root.left);
        mirrorTree(root.right);
        
        // Swap leftTree and rightTree reference
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        
    }
    public TreeNode invertTree(TreeNode root) {
        mirrorTree(root);
        
        return root;
    }
}