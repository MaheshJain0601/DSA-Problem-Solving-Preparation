class Solution {
    int countPaths = 0;
    int countNonObstacle = 0;
    int m, n;
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void backtrack(int[][] grid, int row, int col, int currNonObstableCount) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == -1) {
            return;
        }
        if (grid[row][col] == 2) {
            if (currNonObstableCount == countNonObstacle) {
                countPaths++;
            }
            return;
        }
        grid[row][col] = -1;

        for (int[] direction: directions) {
            int nRow = row + direction[0];
            int nCol = col + direction[1];
            backtrack(grid, nRow, nCol, currNonObstableCount + 1);
        }

        grid[row][col] = 0;
    }

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int row = -1, col = -1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                    countNonObstacle++;
                } else if (grid[i][j] == 0) {
                    countNonObstacle++;
                }
            }
        }

        backtrack(grid, row, col, 0);

        return countPaths;
    }
}