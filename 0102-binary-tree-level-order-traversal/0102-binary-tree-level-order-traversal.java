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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) 
            return result;
        
        int nodeSize;
        List<Integer> subList;
        queue.offer(root);
        while (!queue.isEmpty()) {
            nodeSize = queue.size();
            subList = new LinkedList<>();
            for (int i = 0; i < nodeSize; ++i) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(subList);
        }
        
        return result;
    }
}