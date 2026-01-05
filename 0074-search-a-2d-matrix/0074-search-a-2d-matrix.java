class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Approach-1: Perform Linear Search: O(N*M)
        // Approach-2: Perform Binary search on each row: O(N*LogM)

        // Approach-3: As the entire matrix is sorted in itself, perform binary search on entire on 2D matrix: O(log (M*N))
        int N = matrix.length;
        int M = matrix[0].length;

        int low = 0, high = N*M - 1;
        int mid, row, col;

        while (low <= high) {
            mid = low + (high - low)/2;
            row = mid / M;
            col = mid % M;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}