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
    // BFS
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        int V = image.length;
        int E = image[0].length;

        int[][] newImage = copyImage(image, V, E);

        newImage[sr][sc] = color;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int oldImageCell = image[sr][sc];

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            
            for (int[] direction: directions) {
                int nRow = node[0] + direction[0];
                int nCol = node[1] + direction[1];
                if (nRow < 0 || nRow >= V || nCol < 0 || nCol >= E || newImage[nRow][nCol] == color || image[nRow][nCol] != oldImageCell) {
                    continue;
                }

                newImage[nRow][nCol] = color;
                queue.offer(new int[]{nRow, nCol});
            }
        }

        return newImage;
    }

    // DFS
    private void dfs(int[][] image, int[][] newImage, int V, int E, int row, int col, int initialColor, int newColor) {
        if (row < 0 || col < 0 || row >= V || col >= E || newImage[row][col] == newColor || image[row][col] != initialColor) {
            return;
        }

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        newImage[row][col] = newColor;

        for (int[] direction: directions) {
            int nRow = row + direction[0];
            int nCol = col + direction[1];

            dfs(image, newImage, V, E, nRow, nCol, initialColor, newColor);
        }
    }

    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int V = image.length;
        int E = image[0].length;

        int[][] newImage = copyImage(image, V, E);

        dfs(image, newImage, V, E, sr, sc, image[sr][sc], color);

        return newImage;
    }
}