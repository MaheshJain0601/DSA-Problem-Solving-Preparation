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
    public int maxLevelSumBFS(TreeNode root) {
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

    // DFS
    private void maxLevelSumHelper(TreeNode root, int currentLevel, Map<Integer, Integer> levelSum) {
        if (root == null) return;
        
        levelSum.put(currentLevel, levelSum.getOrDefault(currentLevel, 0) + root.val);

        maxLevelSumHelper(root.left, currentLevel + 1, levelSum);
        maxLevelSumHelper(root.right, currentLevel + 1, levelSum);
    }
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> levelSum = new TreeMap<>();
        maxLevelSumHelper(root, 1, levelSum);

        int maxLevelSum = Integer.MIN_VALUE;
        int maxSumLevel = 0;
        for (Map.Entry<Integer, Integer> entry: levelSum.entrySet()) {
            if (entry.getValue() > maxLevelSum) {
                maxLevelSum = entry.getValue();
                maxSumLevel = entry.getKey();
            }
        }
        return maxSumLevel;
    }
}