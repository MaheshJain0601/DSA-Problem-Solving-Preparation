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
    private TreeNode deleteHelper(TreeNode root, Set<Integer> toBeDeleted, List<TreeNode> result) {
        if (root == null)
            return null;
        
        root.left = deleteHelper(root.left, toBeDeleted, result);
        root.right = deleteHelper(root.right, toBeDeleted, result);

        if (toBeDeleted.contains(root.val)) {
            if (root.left != null) 
                result.add(root.left);
            
            if (root.right != null) 
                result.add(root.right);
            
            return null;
        } else {
            return root;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        List<TreeNode> result = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int deleteVal: toDelete) {
            set.add(deleteVal);
        }

        deleteHelper(root, set, result);

        if (!set.contains(root.val)) {
            result.add(root);
        }

        return result;
        
    }
}