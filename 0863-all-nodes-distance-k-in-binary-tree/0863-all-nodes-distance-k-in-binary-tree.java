/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void parentMapping(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode node;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                parentMap.put(node.left, node);
            }
            if (node.right != null) {
                queue.offer(node.right);
                parentMap.put(node.right, node);
            }
        }
    }

    private void nodesAtDistanceK(TreeNode target, Map<TreeNode, TreeNode> parentMap, List<Integer> result, int k) {
        if (target == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        
        queue.offer(target);
        visited.put(target, true);

        TreeNode node;
        int currDistance = 0, size;

        while (!queue.isEmpty()) {
            if (currDistance == k) {
                break;
            }
            size = queue.size();
            
            while (size > 0) {
                node = queue.poll();
                if (node.left != null && !visited.getOrDefault(node.left, false)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && !visited.getOrDefault(node.right, false)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                
                TreeNode parentNode = parentMap.getOrDefault(node, null);
                if (parentNode != null && !visited.getOrDefault(parentNode, false)) {
                    queue.offer(parentNode);
                    visited.put(parentNode, true);
                }
                size--;
            }
            currDistance++;
        }

        while(!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMapping(root, parentMap);

        nodesAtDistanceK(target, parentMap, result, k);

        return result;
    }
}