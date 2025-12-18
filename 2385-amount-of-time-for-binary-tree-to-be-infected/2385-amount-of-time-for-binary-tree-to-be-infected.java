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
    private void getChildToParentMap(TreeNode root, Map<TreeNode, TreeNode> childToParentMp) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                childToParentMp.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                childToParentMp.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    private TreeNode getStartNode(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;

        TreeNode node;

        node = getStartNode(root.left, start);
        if (node != null) return node;
        node = getStartNode(root.right, start);
        
        return node;
    }

    private int getMinimumAmountOfTime(TreeNode root, Map<TreeNode, TreeNode> childToParentMp, TreeNode startNode) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        
        queue.offer(startNode);
        visited.put(startNode, true);
        int minTime = -1;

        int levelSize;
        TreeNode node, parentNode;

        while (!queue.isEmpty()) {
            levelSize = queue.size();

            while (levelSize > 0) {
                node = queue.poll();

                if (node.left != null && !visited.getOrDefault(node.left, false)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && !visited.getOrDefault(node.right, false)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                parentNode = childToParentMp.get(node);
                if (parentNode != null && !visited.getOrDefault(parentNode, false)) {
                    queue.offer(parentNode);
                    visited.put(parentNode, true);
                }
                levelSize--;
            }
            minTime++;
        }
        return minTime;
    }
    
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) return 0;
        
        Map<TreeNode, TreeNode> childToParentMp = new HashMap<>();
        getChildToParentMap(root, childToParentMp);

        TreeNode startNode = getStartNode(root, start);

        return getMinimumAmountOfTime(root, childToParentMp, startNode);
    }
}