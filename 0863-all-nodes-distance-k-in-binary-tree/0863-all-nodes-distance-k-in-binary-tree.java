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
    public void parentMapping(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMapping(root, parentMap);
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        nodesAtDistanceK(target, parentMap, result, k);
        
        return result;
    }
    
    public void nodesAtDistanceK(TreeNode target, Map<TreeNode, TreeNode> parentMap, List<Integer> result,int k) {
        int currentDistance = 0;
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        while(!queue.isEmpty()) {
            if (currentDistance == k) {
                break;
            }
            int size = queue.size();
            for (int index = 0; index < size; ++index) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.containsKey(node.left)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && !visited.containsKey(node.right)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                TreeNode parentNode = parentMap.get(node);
                if (parentNode != null && !visited.containsKey(parentNode)) {
                    queue.offer(parentNode);
                    visited.put(parentNode, true);
                }
            }
            
            currentDistance++;
        }
        
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        
    }
}