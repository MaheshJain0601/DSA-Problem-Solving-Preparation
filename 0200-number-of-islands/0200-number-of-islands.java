class Solution {
    // DFS Approach
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

    public int numIslandsDFS(char[][] grid) {
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
    // BFS
    static class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }

        int numIslands = 0;
        int V = grid.length;
        int E = grid[0].length;
        boolean[][] visited = new boolean[V][E];
        Queue<Pair> queue = new LinkedList<>();

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numIslands++;
                    queue.offer(new Pair(i, j));

                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        int row = pair.row;
                        int col = pair.col;

                        for(int[] dir: directions) {
                            int nRow = row + dir[0];
                            int nCol = col + dir[1];

                            if (nRow < 0 || nRow >= V || nCol < 0 || nCol >= E || grid[nRow][nCol] != '1' || visited[nRow][nCol]) 
                                continue;
                            
                            visited[nRow][nCol] = true;
                            queue.offer(new Pair(nRow, nCol));
                        }
                    }
                }
            }
        }
        return numIslands;
    }
}