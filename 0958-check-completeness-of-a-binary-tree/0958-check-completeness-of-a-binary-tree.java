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
    public boolean isCompleteTree(TreeNode root) {
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

    private boolean isCompleteTreeHelperDFS(TreeNode root, int index, int totalNodes) {
        if (root == null) {
            return true;
        }

        if (index >= totalNodes) {
            return false;
        }
        return isCompleteTreeHelperDFS(root.left, 2*index + 1, totalNodes)
            && isCompleteTreeHelperDFS(root.right, 2*index + 2, totalNodes);
    }
    public boolean isCompleteTreeDFS(TreeNode root) {
        int totalNodes = countNodes(root);

        int index = 0;
        return isCompleteTreeHelperDFS(root, index, totalNodes);
    }
}