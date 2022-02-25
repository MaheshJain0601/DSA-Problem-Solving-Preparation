class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] transpose = new int[col][row];
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++)
                transpose[c][r] = matrix[r][c];
        return transpose;
    }
}