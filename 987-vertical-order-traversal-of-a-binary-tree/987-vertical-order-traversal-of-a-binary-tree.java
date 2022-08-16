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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<List<Integer>>();
        if (root == null) {
            return answer;
        }
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0, 0, root));
        while (!queue.isEmpty()) {
            Tuple curr = queue.poll();
            int verticalAxis = curr.verticalAxis;
            int horizontalAxis = curr.horizontalAxis;
            TreeNode node = curr.node;
            if (!map.containsKey(verticalAxis)) {
                map.put(verticalAxis, new TreeMap<>());
            }
            
            if (!map.get(verticalAxis).containsKey(horizontalAxis)) {
                map.get(verticalAxis).put(horizontalAxis, new PriorityQueue<Integer>());
            }
            
            map.get(verticalAxis).get(horizontalAxis).offer(node.val);
            
            if (node.left != null) {
                queue.offer(new Tuple(verticalAxis - 1, horizontalAxis + 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new Tuple(verticalAxis + 1, horizontalAxis + 1, node.right));
            }
        }
        
        for (TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()) {
            LinkedList<Integer> subList = new LinkedList<>();
            for (PriorityQueue<Integer> nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    subList.add(nodes.poll());
                }
            }
            answer.add(subList);
        }
        return answer;
    }
       
    
    class Tuple {
        int verticalAxis;
        int horizontalAxis;
        TreeNode node;
        public Tuple(int verticalAxis, int horizontalAxis, TreeNode node) {
            this.verticalAxis = verticalAxis;
            this.horizontalAxis = horizontalAxis;
            this.node = node;
        }
    }
}
    