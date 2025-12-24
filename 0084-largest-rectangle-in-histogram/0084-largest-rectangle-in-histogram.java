class Solution {
    // Approach-1; Multi-pass solution
    private int[] findNextSmallerElement(int[] arr) {
        int N = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[N];
        for (int index = N - 1; index >= 0; --index) {
            // Monotonically decreasing stack
            while (!st.isEmpty() && arr[st.peek()] >= arr[index]) {
                st.pop();
            }
            result[index] = st.isEmpty() ? N : st.peek();
            st.push(index);
        }
        return result;
    }

    private int[] findPreviousSmallerElement(int[] arr) {
        int N = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[N];
        for (int index = 0; index < N; ++index) {
            // Monotonically decreasing stack
            while (!st.isEmpty() && arr[st.peek()] >= arr[index]) {
                st.pop();
            }
            result[index] = st.isEmpty() ? -1 : st.peek();
            st.push(index);
        }
        return result;
    }
    public int largestRectangleAreaApproach1(int[] heights) {
        int N = heights.length;
        int[] nse = findNextSmallerElement(heights);
        int[] pse = findPreviousSmallerElement(heights);

        int maximumHeight = 0;

        for (int index = 0; index < N; ++index) {
            maximumHeight = Math.max(maximumHeight, heights[index] * (nse[index] - pse[index] - 1));
        }
        return maximumHeight;
    }

    // Approach-2
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
}