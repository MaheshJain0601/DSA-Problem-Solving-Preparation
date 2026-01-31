class Solution {
    private int[][] copyImage(int[][] image, int V, int E) {
        int[][] newImage = new int[V][E];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < E; j++) {
                newImage[i][j] = image[i][j];
            }
        }
        return newImage;
    }

    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    // BFS Approach
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        int V = image.length;
        int E = image[0].length;
        int[][] newImage = copyImage(image, V, E);

        int intialColor = newImage[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        newImage[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] direction: directions) {
                int nRow = cell[0] + direction[0];
                int nCol = cell[1] + direction[1];

                if (nRow < 0 || nCol < 0 || nRow >= V || nCol >= E || newImage[nRow][nCol] == color || newImage[nRow][nCol] != intialColor) {
                    continue;
                }
                newImage[nRow][nCol] = color;
                queue.offer(new int[]{nRow, nCol});
            }
        }
        return newImage;
    }

    private void dfs(int[][] newImage, int row, int col, int color, int intialColor) {
        if (row < 0 || col < 0 || row >= newImage.length || col >= newImage[0].length || newImage[row][col] == color || newImage[row][col] != intialColor) {
            return;
        }
        newImage[row][col] = color;
        for (int[] direction: directions) {
            int nRow = row + direction[0];
            int nCol = col + direction[1];

            dfs(newImage, nRow, nCol, color, intialColor);
        }

    }

    // DFS Approach
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int V = image.length;
        int E = image[0].length;
        int[][] newImage = copyImage(image, V, E);

        dfs(newImage, sr, sc, color, newImage[sr][sc]);
        return newImage;
    }
}