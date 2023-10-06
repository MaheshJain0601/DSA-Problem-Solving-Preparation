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
        
        int size;
        boolean leftToRight = true;
        
        while (!queue.isEmpty()) {
            size = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();
            
            for (int index = 0; index < size; index++) {
                TreeNode node = queue.poll();
                if(leftToRight) {
                    subList.add(node.val);
                } else {
                    subList.addFirst(node.val);
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                
            }
            result.add(subList);
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}