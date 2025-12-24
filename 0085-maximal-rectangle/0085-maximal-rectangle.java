class Solution {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int index = 0; index < N; ++index) {
            // Monotonically decreasing stack
            while (!st.isEmpty() && heights[st.peek()] >= heights[index]) {
                int nseElementIndex = st.pop();
                int pseElementIndex = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[nseElementIndex] * (index-pseElementIndex-1));
            }
            
            st.push(index);
        }

        while (!st.isEmpty()) {
            int nseElementIndex = N;
            int index = st.pop();
            int pseElementIndex = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[index] * (nseElementIndex-pseElementIndex-1));
        }

        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefixSum = new int[rows][cols];
        int maxArea = 0;

        for (int i = 0; i < rows; ++i) {
            int sum = 0;
            for (int j = 0; j < cols; ++j) {
                prefixSum[i][j] = (matrix[i][j] - '0');
                if (i >= 1) {
                    prefixSum[i][j] += prefixSum[i-1][j];
                }
                if (matrix[i][j] == '0') {
                    prefixSum[i][j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(prefixSum[i]));
        }
        return maxArea;
    }
}