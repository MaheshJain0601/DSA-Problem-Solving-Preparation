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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()){
            int num = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                TreeNode temp = q.poll();
                if (flag) {
                    level.add(temp.val);
                } else {
                    level.add(0, temp.val);
                }
                if (temp.left != null) {
                    q.offer(temp.left);
                } 
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            result.add(level);
            flag = ! flag;
        }
        return result;
    }
}