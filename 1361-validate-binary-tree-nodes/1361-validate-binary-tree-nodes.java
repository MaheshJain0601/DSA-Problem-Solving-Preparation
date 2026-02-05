class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Integer> childToParentMp = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int node = 0; node < n; ++node) {
            int leftChildNode = leftChild[node];
            int rightChildNode = rightChild[node];

            if (leftChildNode != -1) {
                if (childToParentMp.get(leftChildNode) != null) return false;

                adjList.computeIfAbsent(node, c -> new ArrayList<>()).add(leftChildNode);
                childToParentMp.put(leftChildNode, node);
            }

            if (rightChildNode != -1) {
                if (childToParentMp.get(rightChildNode) != null) return false;

                adjList.computeIfAbsent(node, c -> new ArrayList<>()).add(rightChildNode);
                childToParentMp.put(rightChildNode, node);
            }
        }

        int root = -1;
        for (int node = 0; node < n; ++node) {
            if (childToParentMp.get(node) == null) {
                if (root != -1) return false;
                root = node;
            }
        }

        if (root == -1) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int count = 1;
        
        queue.offer(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!adjList.containsKey(node)) continue;

            for (int adjNode: adjList.get(node)) {
                if (!visited[adjNode]) {
                    queue.offer(adjNode);
                    count++;
                    visited[adjNode] = true;
                }
            }
        }
        return count == n;
    }
}