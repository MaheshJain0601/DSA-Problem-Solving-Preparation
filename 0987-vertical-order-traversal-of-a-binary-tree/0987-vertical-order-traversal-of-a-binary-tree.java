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
    class Tuple {
        int verticalAxis;
        int horizontalAxis;
        TreeNode node;
        public Tuple(TreeNode node, int horizontalAxis, int verticalAxis) {
            this.node = node;
            this.horizontalAxis = horizontalAxis;
            this.verticalAxis = verticalAxis;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, Queue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        Tuple tuple;
        int horizontalAxis, verticalAxis;
        TreeNode node;
        while (!queue.isEmpty()) {
            tuple = queue.poll();

            horizontalAxis = tuple.horizontalAxis;
            verticalAxis = tuple.verticalAxis;
            node = tuple.node;

            if (!map.containsKey(verticalAxis)) {
                map.put(verticalAxis, new TreeMap<>());
            }
            if (!map.get(verticalAxis).containsKey(horizontalAxis)) {
                map.get(verticalAxis).put(horizontalAxis, new PriorityQueue<Integer>());
            }

            map.get(verticalAxis).get(horizontalAxis).offer(node.val);
            if (node.left != null) {
                queue.offer(new Tuple(node.left, horizontalAxis + 1, verticalAxis - 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, horizontalAxis + 1, verticalAxis + 1));
            }
        }

        for (TreeMap<Integer, Queue<Integer>> ys: map.values()) {
            LinkedList<Integer> subList = new LinkedList<>();
            for (Queue<Integer> nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    subList.add(nodes.poll());
                }
            }
            result.add(subList);
        }
        return result;
    }
}