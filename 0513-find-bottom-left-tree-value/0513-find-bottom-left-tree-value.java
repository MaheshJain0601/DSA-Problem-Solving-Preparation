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
    // DFS Approach
    private void findBottomLeftValueHelper(TreeNode root, int currDepth, Pair pair) {
        if (root == null) return;
        
        if (currDepth > pair.depth) {
            pair.depth = currDepth;
            pair.result = root.val;
        }
        findBottomLeftValueHelper(root.left, currDepth + 1, pair);
        findBottomLeftValueHelper(root.right, currDepth + 1, pair);
    }
    public int findBottomLeftValueDFS(TreeNode root) {
        Pair pair = new Pair(-1, 0);
        findBottomLeftValueHelper(root, 0, pair);
        return pair.result;
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelSize, result = 0;
        TreeNode node;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            while (levelSize > 0) {
                node = queue.poll();
                result = node.val;

                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);

                levelSize--;
            }
        }
        return result;
    }
}