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
    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeafNode(root)) {
            return 1;
        }

        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
        
        return 1 + Math.min(leftDepth, rightDepth);
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int depth = 1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();

                if (isLeafNode(node)) {
                    return depth;
                }
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }
        
        return depth;
    }

    public int minDepth(TreeNode root) {
        return minDepthBFS(root);
    }
}