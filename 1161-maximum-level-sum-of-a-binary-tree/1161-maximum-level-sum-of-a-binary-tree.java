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
    // BFS
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int currentLevel = 1;
        int levelSize, levelSum;

        int maxLevelSum = Integer.MIN_VALUE, levelNum = 0;

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            levelSum = 0;
            while (levelSize > 0) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                levelSize--;
            }
            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                levelNum = currentLevel;
            }
            currentLevel++;
        }
        return levelNum;
    }
}