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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<>();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode temp = nodes.poll();
                subList.add(temp.val);
                if (temp.left != null) {
                    nodes.offer(temp.left);
                }
                if (temp.right != null) {
                    nodes.offer(temp.right);
                }
            }
            answer.add(0, subList);
        }
        return answer;
        
    }
}