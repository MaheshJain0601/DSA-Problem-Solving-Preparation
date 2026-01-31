class Solution {
    static class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int V = grid.length;
        int E = grid[0].length;

        int totalFreshOranges = 0;
        boolean[][] visited = new boolean[V][E];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    totalFreshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true;
                }   
            }
        }
        if (totalFreshOranges == 0) return 0;

        int minTime = 0;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level > 0) {
                Pair cell = queue.poll();

                for (int[] direction: directions) {
                    int nRow = cell.row + direction[0];
                    int nCol = cell.col + direction[1];
                    if (nRow < 0 || nCol < 0 || nRow >= V || nCol >= E || grid[nRow][nCol] != 1 || visited[nRow][nCol]) {
                        continue;
                    }
                    queue.offer(new Pair(nRow, nCol));
                    visited[nRow][nCol] = true;
                    cnt++;
                }
                level--;
            }
            minTime++;
        }
        if (cnt != totalFreshOranges) {
            return -1;
        }
        return minTime - 1;
    }
}