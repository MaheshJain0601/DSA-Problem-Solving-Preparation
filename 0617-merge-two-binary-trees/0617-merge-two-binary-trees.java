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
    // T.C --> O(n)   ||  S.C --> O(h)
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 == null) {
            return root1;
        }
        if (root1 == null && root2 != null) {
            return root2;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);

        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public TreeNode mergeTreesNewNodes(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 == null) {
            return root1;
        }
        if (root1 == null && root2 != null) {
            return root2;
        }

        TreeNode root = new TreeNode(root1.val + root2.val);

        root.left = mergeTreesNewNodes(root1.left, root2.left);

        root.right = mergeTreesNewNodes(root1.right, root2.right);

        return root;
    }
}