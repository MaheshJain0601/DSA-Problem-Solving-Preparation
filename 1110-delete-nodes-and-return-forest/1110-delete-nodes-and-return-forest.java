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
    public TreeNode delNodesHelper(TreeNode root, List<TreeNode> result, Set<Integer> toBeDeleted) {
        if (root == null) {
            return null;
        }
        root.left = delNodesHelper(root.left, result, toBeDeleted);
        root.right = delNodesHelper(root.right, result, toBeDeleted);
        if (toBeDeleted.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toBeDeleted = new HashSet<>();
        for (int deleteNode: to_delete) {
            toBeDeleted.add(deleteNode);
        }
        List<TreeNode> result = new ArrayList<>();
        delNodesHelper(root, result, toBeDeleted);
        if (!toBeDeleted.contains(root.val)) {
            result.add(root);
        }
        return result;
    }
}