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
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelSize;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            TreeNode node = null;
            while (levelSize > 0) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                levelSize--;
            }
            result.add(node.val);
        }

        return result;
    }

    // DFS Approach
    private void rightSideViewHelper(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(root.val);
        }
        rightSideViewHelper(root.right, result, level+1);
        rightSideViewHelper(root.left, result, level+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        rightSideViewHelper(root, result, 0);
        return result;
    }
}