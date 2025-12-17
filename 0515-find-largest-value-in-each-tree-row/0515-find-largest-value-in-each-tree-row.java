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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int currentLevelSize, maxElementLevel;

        while (!queue.isEmpty()) {
            currentLevelSize = queue.size();
            maxElementLevel = Integer.MIN_VALUE;

            while (currentLevelSize > 0) {
                TreeNode node = queue.poll();
                
                maxElementLevel = Math.max(maxElementLevel, node.val);

                if (node.left != null) queue.offer(node.left);

                if (node.right != null) queue.offer(node.right);

                currentLevelSize--;
            }
            result.add(maxElementLevel);
        }
        return result;
    }
}