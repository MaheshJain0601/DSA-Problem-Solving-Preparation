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
    int sumEvenValuedGrandParents = 0;
    
    public void dfsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    sumEvenValuedGrandParents += root.left.left.val;
                }
                if (root.left.right != null) {
                    sumEvenValuedGrandParents += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    sumEvenValuedGrandParents += root.right.left.val;
                }
                if (root.right.right != null) {
                    sumEvenValuedGrandParents += root.right.right.val;
                }
            }
        }
        dfsTraversal(root.left);
        dfsTraversal(root.right);
    }
    public int sumEvenGrandparent(TreeNode root) {
        dfsTraversal(root);
        return sumEvenValuedGrandParents;
    }
}