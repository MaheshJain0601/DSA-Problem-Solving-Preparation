class Solution {
    // DFS Approach
    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        // Top
        dfs(grid, visited, row - 1, col);
        // Right
        dfs(grid, visited, row, col + 1);
        // Bottom
        dfs(grid, visited, row + 1, col);
        // Left
        dfs(grid, visited, row , col - 1);
    }
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int V = grid.length;
        int E = grid[0].length;
        boolean[][] visited = new boolean[V][E];
        int numOfIslands = 0;
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    static class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    // BFS Approach
    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            row = queue.peek().row;
            col = queue.peek().col;
            queue.poll();

            for (int[] direction: directions) {
                int nRow = row + direction[0];
                int nCol = col + direction[1];

                if (nRow < 0 || nRow >= grid.length || nCol < 0 || nCol >= grid[0].length || grid[nRow][nCol] != '1' || visited[nRow][nCol]) {
                    continue;
                }
                queue.offer(new Pair(nRow, nCol));
                visited[nRow][nCol] = true;
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int V = grid.length;
        int E = grid[0].length;
        boolean[][] visited = new boolean[V][E];
        int numOfIslands = 0;
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
}