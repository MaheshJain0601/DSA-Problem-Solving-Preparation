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
    private TreeNode addOneRowHelper(TreeNode root, int val, int depth, int currDepth) {
        if (root == null) return root;

        if (currDepth == depth - 1) {
            TreeNode leftSubTreeTemp = root.left;
            TreeNode rightSubTreeTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = leftSubTreeTemp;
            root.right.right = rightSubTreeTemp;
            return root;
        }

        root.left = addOneRowHelper(root.left, val, depth, currDepth + 1);
        root.right = addOneRowHelper(root.right, val, depth, currDepth + 1);
        
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        int currDepth = 1;

        return addOneRowHelper(root, val, depth, currDepth);
    }
}