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
    private boolean isLeafNode(TreeNode node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
    private void pathSumHelper(TreeNode root, int targetSum, int currSum, List<Integer> path, List<List<Integer>> allPaths) {
        if (root == null) return;

        currSum += root.val;
        path.add(root.val);

        if (isLeafNode(root)) {
            if (currSum == targetSum) {
                allPaths.add(new LinkedList<>(path));
            }
        }
        
        pathSumHelper(root.left, targetSum, currSum, path, allPaths);
        pathSumHelper(root.right, targetSum, currSum, path, allPaths);

        path.remove(path.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();

        pathSumHelper(root, targetSum, 0, new LinkedList<>(), result);
        return result;
    }
}