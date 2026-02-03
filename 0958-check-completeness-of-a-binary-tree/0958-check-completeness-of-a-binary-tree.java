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
    public boolean isCompleteTreeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean pastNull = false;
        TreeNode node;
        
        queue.offer(root);

        while(!queue.isEmpty()) {
            node = queue.poll();

            if (node == null) {
                pastNull = true;
            } else {
                if (pastNull) {
                    return false;
                }

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
    // DFS
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean isCompleteTreeHelper(TreeNode root, int totalNodes, int index) {
        if (root == null) {
            return true;
        }
        if (index >= totalNodes) {
            return false;
        }

        return isCompleteTreeHelper(root.left, totalNodes, 2 * index + 1)
            && isCompleteTreeHelper(root.right, totalNodes, 2 * index + 2);
    }

    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);

        return isCompleteTreeHelper(root, totalNodes, 0);
    }
}