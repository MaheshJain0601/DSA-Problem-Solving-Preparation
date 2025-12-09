class Solution {
    static class Triplet {
        int row;
        int col;
        int time;
        public Triplet(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int V = grid.length;
        int E = grid[0].length;

        int totalFreshOranges = 0;
        Queue<Triplet> queue = new LinkedList<>();
        boolean[][] visited = new boolean[V][E];

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    totalFreshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new Triplet(i, j, 0));
                    visited[i][j] = true;
                }   
            }
        }

        int maxTime = 0;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int count = 0;

        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            int row = triplet.row;
            int col = triplet.col;
            int time = triplet.time;
            maxTime = Math.max(maxTime, time);

            for (int[] direction: directions) {
                int nRow = row + direction[0];
                int nCol = col + direction[1];
                if (nRow < 0 || nRow >= V || nCol < 0 || nCol >= E || grid[nRow][nCol] != 1 || visited[nRow][nCol]) {
                    continue;
                }
                queue.offer(new Triplet(nRow, nCol, time + 1));
                visited[nRow][nCol] = true;
                count++;
            }
        }

        if (count != totalFreshOranges)
            return -1;

        return maxTime;
    }
}