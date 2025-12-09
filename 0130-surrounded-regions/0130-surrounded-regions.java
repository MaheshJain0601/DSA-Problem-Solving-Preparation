class Solution {
    static class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(char[][] board, boolean[][] visited, Pair pair) {
        int row = pair.row;
        int col = pair.col;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        for (int[] direction: directions) {
            int nRow = row + direction[0];
            int nCol = col + direction[1];
            dfs(board, visited, new Pair(nRow, nCol));
        }
    }
    public void solve(char[][] board) {
        int V = board.length;
        int E = board[0].length;

        boolean[][] visited = new boolean[V][E];

        // Cover boundaries
        // first row and last row
        for (int i = 0; i < E; ++i) {
            if (!visited[0][i] && board[0][i] == 'O') {
                dfs(board, visited, new Pair(0, i));
            }

            if (!visited[V-1][i] && board[V-1][i] == 'O') {
                dfs(board, visited, new Pair(V-1, i));
            }
        }

        // First column and last column
        for (int i = 0; i < V; ++i) {
            if (!visited[i][0] && board[i][0] == 'O') {
                dfs(board, visited, new Pair(i, 0));
            }

            if (!visited[i][E-1] && board[i][E-1] == 'O') {
                dfs(board, visited, new Pair(i, E-1));
            }
        }

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                if (!visited[i][j] && board[i][j] == 'O') 
                    board[i][j] = 'X';
            }
        }
    }
}