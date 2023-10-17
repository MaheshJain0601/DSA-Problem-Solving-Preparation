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
    private TreeNode deleteNodesReturnForest(TreeNode root, Set<Integer> toDelete, List<TreeNode> result) {
        if (root == null) {
            return root;
        }
        
        root.left = deleteNodesReturnForest(root.left, toDelete, result);
        root.right = deleteNodesReturnForest(root.right, toDelete, result);
        
        if (toDelete.contains(root.val)) {
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
        List<TreeNode> result = new ArrayList<>();
        if (result == null) {
            return result; 
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int element: to_delete) {
            hashSet.add(element);
        }
        
        TreeNode node = deleteNodesReturnForest(root, hashSet, result);
        if (node != null) {
            result.add(root);
        }
        
        return result;
    }
}