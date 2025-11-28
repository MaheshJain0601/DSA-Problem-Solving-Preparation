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
    TreeNode previous = null;
    public void flattenRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = previous;
        root.left = null;

        previous = root;
    }

    public void flatten(TreeNode root) {
        TreeNode currNode = root;
        while (currNode != null) {
            if (currNode.left != null) {
                TreeNode leftChild = currNode.left;
                while (leftChild.right != null) {
                    leftChild = leftChild.right;
                }
                leftChild.right = currNode.right;
                currNode.right = currNode.left;
                currNode.left = null;
            } 
            currNode = currNode.right;
        }
    }
}