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
    private void inOrderTraversal(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            sb.append(root.val + "|");
            return;
        }
        
        inOrderTraversal(root.left, sb);
        inOrderTraversal(root.right, sb);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        inOrderTraversal(root1, sb1);
        
        StringBuilder sb2 = new StringBuilder();
        inOrderTraversal(root2, sb2);
        // System.out.println("s1: " + sb1.toString());
        // System.out.println("s2: " + sb2.toString());
        return (sb1.toString().equals(sb2.toString()));
    }
}