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
    public TreeNode balanceBSTHelper(List<Integer> inOrderPath, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left)/2;
        TreeNode newRoot = new TreeNode(inOrderPath.get(mid));
        newRoot.left = balanceBSTHelper(inOrderPath, left, mid - 1);
        newRoot.right = balanceBSTHelper(inOrderPath, mid + 1, right);
        return newRoot;        
    }

    private void inOrder(TreeNode root, List<Integer> inOrderPath) {
        if (root == null) return;
        inOrder(root.left, inOrderPath);
        inOrderPath.add(root.val);
        inOrder(root.right, inOrderPath);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrderPath = new ArrayList<>();
        inOrder(root, inOrderPath);
        return balanceBSTHelper(inOrderPath, 0, inOrderPath.size() - 1);
    }
}