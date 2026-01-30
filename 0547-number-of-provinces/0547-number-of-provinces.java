class Solution {
    private List<List<Integer>> getAdjancencyList(int[][] isConnected, int V, int E) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int index = 0; index < V; ++index) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (isConnected[i][j] == 1 && (i != j)) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        return adjList;
    }
    private void bfs(List<List<Integer>> adjList, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();

            for (Integer adjNode: adjList.get(node)) {
                if (!visited[adjNode]) {
                    queue.offer(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int E = isConnected[0].length;
        List<List<Integer>> adjList = getAdjancencyList(isConnected, V, E);

        boolean[] visited = new boolean[V];

        int numProvinces = 0;
        for (int index = 0; index < V; ++index) {
            if (!visited[index]) {
                bfs(adjList, visited, index);
                numProvinces++;
            }
        }
        return numProvinces;
    }
}