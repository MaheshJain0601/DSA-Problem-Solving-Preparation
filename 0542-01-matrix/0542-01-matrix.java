class Solution {
    static class Triplet {
        int row;
        int col;
        int distance;
        public Triplet(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {
        int V = mat.length;
        int E = mat[0].length;

        int[][] cellDistance = new int[V][E];
        boolean[][] visited = new boolean[V][E];
        Queue<Triplet> queue = new LinkedList<>();
        
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new Triplet(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int distance = queue.peek().distance;
            queue.poll();

            cellDistance[row][col] = distance;
            for (int[] direction: directions) {
                int nRow = row + direction[0];
                int nCol = col + direction[1];

                if (nRow < 0 || nRow >= V || nCol < 0 || nCol >= E || mat[nRow][nCol] == 0 || visited[nRow][nCol]) {
                    continue;
                }

                queue.offer(new Triplet(nRow, nCol, distance + 1));
                visited[nRow][nCol] = true;
            }
        }
        return cellDistance;
    }
}