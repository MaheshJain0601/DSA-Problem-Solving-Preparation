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
    static class Pair {
        int depth;
        int result;
        public Pair(int depth, int result) {
            this.depth = depth;
            this.result = result;
        }
    }
    private void findBottomLeftValueHelper(TreeNode root, int currDepth, Pair pair) {
        if (root == null) return;
        
        if (currDepth > pair.depth) {
            pair.depth = currDepth;
            pair.result = root.val;
        }
        findBottomLeftValueHelper(root.left, currDepth + 1, pair);
        findBottomLeftValueHelper(root.right, currDepth + 1, pair);
    }
    public int findBottomLeftValue(TreeNode root) {
        Pair pair = new Pair(-1, 0);
        findBottomLeftValueHelper(root, 0, pair);
        return pair.result;
    }
}