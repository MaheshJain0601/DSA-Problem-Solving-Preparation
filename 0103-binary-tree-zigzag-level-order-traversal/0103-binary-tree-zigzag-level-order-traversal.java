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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            int num = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                TreeNode temp = queue.poll();
                if (flag) {
                    level.add(temp.val);
                } else {
                    level.addFirst(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                } 
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(level);
            flag = ! flag;
        }
        return result;
    }
}