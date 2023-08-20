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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        String path = Integer.toString(root.val);
        if (root.left == null && root.right == null) {
            result.add(path);
        }
        dfs(root.left, result, path);
        dfs(root.right, result, path);
        
        
        return result;
    }
    
    public void dfs(TreeNode node, List<String> result, String path) {
        if (node == null) {
            return;
        }
        
        path = path + "->" + Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            result.add(path);
        }
        
        dfs(node.left, result, path);
        dfs(node.right, result, path);
    }
}