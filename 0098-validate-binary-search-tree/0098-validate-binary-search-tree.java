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
    public boolean isValidBSTHelper(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) {
            return true;
        }
        
        if ((minNode != null && root.val <= minNode.val) || (maxNode != null && root.val >= maxNode.val)) {
            return false;
        }
        
        return (
            isValidBSTHelper(root.left, minNode, root) 
            &&
            isValidBSTHelper(root.right, root, maxNode)
        );
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }
}