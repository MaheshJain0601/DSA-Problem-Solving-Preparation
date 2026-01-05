class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Approach-1: Perform Linear Search: O(N*M)
        // Approach-2: As each row is sorted; perform binary search on each row: O(NLogM)

        // Approach-3: As row and col are sorted in their respective views start elimation: O(N+M)
        int N = matrix.length;
        int M = matrix[0].length;

        int row = 0, col = M - 1;
        while (row < N && col >= 0) {
            if (matrix[row][col] == target) return true;

            if (matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}