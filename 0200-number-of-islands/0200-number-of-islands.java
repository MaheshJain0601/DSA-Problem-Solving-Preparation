class Solution {
    // BFS Approach
    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        // Top
        dfs(grid, visited, row - 1, col);
        // Bottom
        dfs(grid, visited, row + 1, col);
        // Left
        dfs(grid, visited, row , col - 1);
        // Right
        dfs(grid, visited, row, col + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }

        int numIslands = 0;
        int V = grid.length;
        int E = grid[0].length;
        boolean[][] visited = new boolean[V][E];
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numIslands++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return numIslands;
    }
}