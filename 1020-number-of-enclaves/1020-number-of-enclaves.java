class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numEnclaves(int[][] grid) {
        int V = grid.length;
        int E = grid[0].length;

        boolean[][] visited = new boolean[V][E];
        Queue<int[]> queue = new LinkedList<>();
        // Boundary traversal
        // Top and bottom
        for (int i = 0; i < E; ++i) {
            if (!visited[0][i] && grid[0][i] == 1) {
                visited[0][i] = true;
                queue.offer(new int[]{0, i});
            }

            if (!visited[V-1][i] && grid[V-1][i] == 1) {
                visited[V-1][i] = true;
                queue.offer(new int[]{V-1, i});
            }
        }

        // Left and right
        for (int i = 0; i < V; ++i) {
            if (!visited[i][0] && grid[i][0] == 1) {
                visited[i][0] = true;
                queue.offer(new int[]{i, 0});
            }

            if (!visited[i][E-1] && grid[i][E-1] == 1) {
                visited[i][E-1] = true;
                queue.offer(new int[]{i, E-1});
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            
            for (int[] direction: directions) {
                int nRow = node[0] + direction[0];
                int nCol = node[1] + direction[1];

                if (nRow < 0 || nRow >= V || nCol < 0 || nCol >= E || grid[nRow][nCol] == 0 || visited[nRow][nCol]) {
                    continue;
                }
                visited[nRow][nCol] = true;
                queue.offer(new int[]{nRow, nCol});
            }
        }

        int counter = 0;
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }
}