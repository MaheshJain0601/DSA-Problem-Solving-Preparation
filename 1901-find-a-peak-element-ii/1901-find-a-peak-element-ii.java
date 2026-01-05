class Solution {
    private int findMaxElement(int[][] mat, int col) {
        int maxVal = -1;
        int maxValRowIndex = -1;
        for (int row = 0; row < mat.length; ++row) {
            if (mat[row][col] > maxVal) {
                maxVal = mat[row][col];
                maxValRowIndex = row;
            }
        }
        return maxValRowIndex;
    }
    public int[] findPeakGrid(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;

        int low = 0, high = M-1, mid;
        int rowIndex;
        while (low <= high) {
            mid = low + (high - low)/2;
            rowIndex = findMaxElement(mat, mid);
            int left = mid - 1 >= 0 ? mat[rowIndex][mid-1] : -1;
            int right = mid + 1 < M ? mat[rowIndex][mid+1] : -1;
            if (mat[rowIndex][mid] > left && mat[rowIndex][mid] > right) {
                return new int[]{rowIndex, mid};
            } else if (mat[rowIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
        
    }
}