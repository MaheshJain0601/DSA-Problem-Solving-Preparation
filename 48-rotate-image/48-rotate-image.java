class Solution {
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = row; col < matrix[row].length; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        for (int row = 0; row < matrix.length; ++row) {
            reverse(matrix[row], 0, matrix[row].length-1);
        }
    }
}