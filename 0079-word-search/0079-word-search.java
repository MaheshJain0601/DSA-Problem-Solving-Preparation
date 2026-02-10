class Solution {
    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean existHelper(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '$' || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '$';
        for (int[] direction: directions) {
            if (existHelper(board, word, i + direction[0], j + direction[1], idx + 1)) {
                return true;
            }
        }
        board[i][j] = tmp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == word.charAt(0) && existHelper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}