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
    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
    private void preOrderTraversal(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        if (isLeafNode(root)) {
            sb.append(root.val + "|");
            return;
        }
        
        preOrderTraversal(root.left, sb);
        preOrderTraversal(root.right, sb);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        preOrderTraversal(root1, sb1);
        
        StringBuilder sb2 = new StringBuilder();
        preOrderTraversal(root2, sb2);
        return (sb1.toString().equals(sb2.toString()));
    }
}