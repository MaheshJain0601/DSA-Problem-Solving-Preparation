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
    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
    private void binaryTreePathsHelper(TreeNode root, List<String> path, List<String> result) {
        if (root == null) {
            return;
        }

        path.add(Integer.toString(root.val));
        if (isLeafNode(root)) {
            result.add(String.join("->", path));
        }
        
        binaryTreePathsHelper(root.left, path, result);
        binaryTreePathsHelper(root.right, path, result);

        path.remove(path.size() - 1);        
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        List<String> result = new ArrayList<>();
        binaryTreePathsHelper(root, path, result);
        return result;
    }
}