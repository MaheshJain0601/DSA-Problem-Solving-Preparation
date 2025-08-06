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
    public int maximumDiameterOfBinaryTree(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maximumDiameterOfBinaryTree(root.left, diameter);
        int rightHeight = maximumDiameterOfBinaryTree(root.right, diameter);
        
        // Compute maximum diameter at currentNode
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        
        // return the height of the Tree at currentNode
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        maximumDiameterOfBinaryTree(root, diameter);
        return diameter[0];
    }
}