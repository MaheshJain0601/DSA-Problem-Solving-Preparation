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
    // Tree Approach
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

    public int amountOfTimeTree(TreeNode root, int start) {
        if (root == null) return 0;
        
        Map<TreeNode, TreeNode> childToParentMp = new HashMap<>();
        getChildToParentMap(root, childToParentMp);

        TreeNode startNode = getStartNode(root, start);

        return getMinimumAmountOfTime(root, childToParentMp, startNode);
    }

    // Graph Approach

    private void makeGraph(TreeNode root, int parent, Map<Integer, List<Integer>> adjList) {
        if (root == null) return;

        if (parent != -1)
            adjList.computeIfAbsent(root.val, p -> new ArrayList<>()).add(parent);
        
        if (root.left != null) 
            adjList.computeIfAbsent(root.val, p -> new ArrayList<>()).add(root.left.val);
        
        if (root.right != null) 
            adjList.computeIfAbsent(root.val, p -> new ArrayList<>()).add(root.right.val);

        makeGraph(root.left, root.val, adjList);
        makeGraph(root.right, root.val, adjList);
    }

    private int getMinimumAmountOfTimeGraph(Map<Integer, List<Integer>> adjList, int start) {
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);
        int minTime = 0;

        int levelSize;
        int node;

        while (!queue.isEmpty()) {
            levelSize = queue.size();

            while (levelSize > 0) {
                node = queue.poll();
                
                if (!adjList.containsKey(node)) {
                    levelSize--;
                    continue;
                }

                for (Integer adjNode: adjList.get(node)) {
                    if (!visited.contains(adjNode)) {
                        queue.offer(adjNode);
                        visited.add(adjNode);
                    }
                }
                levelSize--;
            }
            minTime++;
        }
        return minTime - 1;
    }


    // One-pass solution: Very important
    private int solve(TreeNode root, int[] result, int start) {
        if (root == null) return 0;

        int leftHeight = solve(root.left, result, start);
        int rightHeight = solve(root.right, result, start);

        if (root.val == start) {
            result[0] = Math.max(leftHeight, rightHeight);
            return -1;
        } else if (leftHeight >= 0 && rightHeight >= 0) {
            return 1 + Math.max(leftHeight, rightHeight);
        } else {
            int maxDepth = Math.abs(leftHeight) + Math.abs(rightHeight);
            result[0] = Math.max(result[0], maxDepth);
            return Math.min(leftHeight, rightHeight) - 1;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        if (root == null) return 0;
        
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;

        solve(root, result, start);

        return result[0];
    }
}