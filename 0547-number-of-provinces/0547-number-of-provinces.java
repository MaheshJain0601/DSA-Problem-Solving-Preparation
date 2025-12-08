class Solution {
    private List<List<Integer>> getAdjacencyList(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>(V);

        for (int i = 0; i < V; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < isConnected[i].length; ++j) {
                if (isConnected[i][j] == 1 && !(i==j)) {
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;
    }
    private void dfs(List<List<Integer>> adjList, boolean[] visited, int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (Integer adjNode: adjList.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjList, visited, adjNode);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = getAdjacencyList(isConnected);
        int V = adjList.size();
        int numOfProvinces = 0;

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                numOfProvinces++;
                dfs(adjList, visited, i);
                
            }
        }
        return numOfProvinces;
    }
}