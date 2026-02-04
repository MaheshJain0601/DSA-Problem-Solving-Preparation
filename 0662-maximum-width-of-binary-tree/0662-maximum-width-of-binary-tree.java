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
        TreeNode node;
        int index;
        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
        public String toString() {
            return node.val + " " + index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int maxWidth = 0;
        Pair pair;
        TreeNode node;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int baseLineIndex = queue.peek().index;

            int first = 0, last = 0;

            for (int index = 0; index < levelSize; ++index) {
                pair = queue.poll();
                node = pair.node;
                int currIndex = pair.index - baseLineIndex;
                if (index == 0) first = currIndex;
                if (index == levelSize - 1) last = currIndex;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * currIndex + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * currIndex + 2));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}