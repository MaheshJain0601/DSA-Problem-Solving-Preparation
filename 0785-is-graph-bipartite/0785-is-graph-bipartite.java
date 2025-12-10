class Solution {
    // BFS
    private boolean bfs(int[][] graph, int[] colors, int src) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        colors[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int adjNode: graph[node]) {
                if (colors[adjNode] == -1) {
                    colors[adjNode] = 1 - colors[node];
                    queue.offer(adjNode);
                } else if (colors[node] == colors[adjNode]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartiteBFS(int[][] graph) {
        int V = graph.length;
        int E = graph[0].length;

        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < V; ++i) {
            if (colors[i] == -1) {
                if (!bfs(graph, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    // DFS
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int E = graph[0].length;

        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < V; ++i) {
            if (colors[i] == -1) {
                if (!dfs(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int src, int color) {
        colors[src] = color;

        for (int adjNode: graph[src]) {
            if (colors[adjNode] == -1) {
                if(!dfs(graph, colors, adjNode, 1 - color)) {
                    return false;
                }
            } else if (colors[adjNode] == color) {
                return false;
            }
        }
        return true;
    }
}